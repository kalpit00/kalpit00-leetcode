// Last updated: 6/11/2025, 2:16:19 AM
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        Integer[][] dp = new Integer[n + 1][n + 1];
        return solve(0, n - 1, arr, dp);
    }
    private int solve(int i, int j, int[] arr, Integer[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = arr[i], right = arr[j];
            for (int t = i; t <= k; t++) {
                left = Math.max(left, arr[t]);
            }
            for (int t = k + 1; t <= j; t++) {
                right = Math.max(right, arr[t]);
            }
            min = Math.min(min, left * right + solve(i, k, arr, dp) + solve(k + 1, j, arr, dp));
        }
        return dp[i][j] = min;
    }
}