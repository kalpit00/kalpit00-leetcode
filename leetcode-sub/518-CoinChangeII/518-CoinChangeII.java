// Last updated: 5/18/2025, 1:20:04 PM
class Solution {
    int limit = 5000;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        return solve(0, n, 0, amount, coins, dp);
    }
    private int solve(int i, int n, int sum, int amount, 
    int[] coins, Integer[][] dp) {
        if (sum == amount) {
            return 1;
        }
        if (i >= n || sum > amount) {
            return 0;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        int notTake = solve(i + 1, n, sum, amount, coins, dp);
        int take = 0;
        for (int j = 1; j <= limit; j++) {
            if (sum + j * coins[i] > amount) break;
            take += solve(i + 1, n, sum + (j * coins[i]), amount, coins, dp);
        }
        return dp[i][sum] = take + notTake;
    }
}