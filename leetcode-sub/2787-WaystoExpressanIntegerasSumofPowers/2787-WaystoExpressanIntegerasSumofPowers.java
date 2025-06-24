// Last updated: 6/24/2025, 3:41:15 PM
class Solution {
    int mod = 1000000007;
    public int numberOfWays(int a, int b) {
        int n = (int) Math.round(Math.pow(a, 1.0 / b));
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) Math.pow(i + 1, b);
        }        
        int[][] dp = new int[n + 1][a + 1];   
        dp[n][a] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int sum = 0; sum <= a; sum++) {
                int notTake = dp[i + 1][sum];
                int take = 0;
                if (sum + nums[i] <= a) {
                    take = dp[i + 1][sum + nums[i]];
                }
                dp[i][sum] = (take + notTake) % mod;
            }
        }
        return dp[0][0];
    }
}