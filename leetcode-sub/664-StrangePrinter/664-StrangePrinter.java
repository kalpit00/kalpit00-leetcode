// Last updated: 6/11/2025, 2:29:36 PM
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return solve(0, n - 1, s.toCharArray(), dp);
    }
    private int solve(int i, int j, char[] s, Integer[][] dp) {
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, solve(i, k, s, dp) + solve(k + 1, j, s, dp));
        }
        return dp[i][j] = s[i] == s[j] ? min - 1 : min;
    }
}