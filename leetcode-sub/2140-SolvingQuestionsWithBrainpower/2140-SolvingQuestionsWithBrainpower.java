// Last updated: 3/31/2025, 9:14:51 PM
class Solution {
    public long mostPoints(int[][] nums) {
        int n= nums.length;
        long dp[]= new long[n];
        long mx=0;
        for(int i=0;i<n;i++){
            int nxt= nums[i][1]+i+1;
            if(i!=0)
            dp[i]=Math.max(dp[i], dp[i-1]);
            if(nxt>=n){
                mx= Math.max(mx,dp[i]+nums[i][0]);
            }else{
                dp[nxt]=Math.max(dp[nxt], dp[i]+nums[i][0]);
            }
            mx= Math.max(dp[i],mx);
        }
        // for(long val:dp){
        //     mx= Math.max(mx,val);
        // }
        return mx;
    }
}