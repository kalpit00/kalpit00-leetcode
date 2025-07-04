// Last updated: 7/4/2025, 1:07:01 PM
class Solution {
    private int[] prefix;
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        prefix = new int[n+1];
        prefix[0] = 0;
        int min = 0;
        for(int i = 1; i<=n; i++){
            prefix[i] = prefix[i-1] + nums.get(i-1);
            if (i>=l){
                int pivot = i-l;
                do{
                    int value = prefix[i]-prefix[pivot];
                    if ((min == 0 && value>0) || (value>0 && min != 0 && value<min)){
                        min = value;
                    };
                    pivot--;
                }while (pivot>=0 && i-pivot<=r);
            };

        };
        if (min == 0){
            return -1;
        }
        else{
            return min;
        }



    }
}