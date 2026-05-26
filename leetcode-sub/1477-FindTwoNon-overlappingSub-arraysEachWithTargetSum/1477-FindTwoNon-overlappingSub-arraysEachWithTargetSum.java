// Last updated: 5/25/2026, 10:07:37 PM
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
       int[] min_len = new int[arr.length];
        Arrays.fill(min_len, Integer.MAX_VALUE);
        
        int sum = 0;
        int start = 0;
        int res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int end = 0; end < arr.length; end++){
            sum += arr[end];
            
            while(sum > target){
                sum -= arr[start++];
            }
            
            if(sum == target){
                int cur_len = end-start+1;
                if(start > 0 && min_len[start-1] != Integer.MAX_VALUE){
                    res = Math.min(res, cur_len + min_len[start-1]);
                }
                min = Math.min(min, cur_len);
            }
            min_len[end] = min;
        }
        
        return res == Integer.MAX_VALUE ? -1 : res; 
    }
}