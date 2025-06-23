// Last updated: 6/23/2025, 2:23:46 PM
class Solution {
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
        if (sum + coins[i] <= amount) {
            take += solve(i, n, sum + coins[i], amount, coins, dp);
        }
        return dp[i][sum] = take + notTake;
    }
}