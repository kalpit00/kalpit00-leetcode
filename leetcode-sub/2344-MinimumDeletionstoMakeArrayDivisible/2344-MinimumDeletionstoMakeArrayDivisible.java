// Last updated: 9/12/2025, 12:22:20 AM
class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int g=numsDivide[0];
        for(int i=1;i<numsDivide.length;i++){
        g=gcd(g,numsDivide[i]);
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(g%nums[i]==0){
                return i;
            }
        }
            return -1;

        }
        private int gcd(int a,int b){
            while(b!=0){
                int temp=a%b;
                a=b;
                b=temp;
            }
            return a;
        }
}