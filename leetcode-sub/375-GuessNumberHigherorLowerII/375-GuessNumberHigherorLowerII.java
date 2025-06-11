// Last updated: 6/11/2025, 2:32:13 PM
class Solution {
    public int getMoneyAmount(int n) {
        Integer[][] dp = new Integer[n + 1][n + 1];
        return solve(1, n, dp);
    }
    private int solve(int i, int j, Integer[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int max = Math.max(solve(i, k - 1, dp), solve(k + 1, j, dp));
            min = Math.min(min, max + k);
        }
        return dp[i][j] = min;
    }
}