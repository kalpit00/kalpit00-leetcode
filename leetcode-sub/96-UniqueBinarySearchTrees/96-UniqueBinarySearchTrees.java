// Last updated: 6/11/2025, 3:18:34 PM
class Solution {
    public int numTrees(int n) {
        Integer[][] dp = new Integer[n][n];
        return solve(0, n - 1, dp);   
    }
	private int solve(int i, int j, Integer[][] dp) {
        if (i > j) {
            return 1;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int count = 0;
        for (int k = i; k <= j; k++) {
            count += solve(i, k - 1, dp) * solve(k + 1, j, dp);
        }
        return dp[i][j] = count;
    }
}