// Last updated: 6/11/2025, 2:16:30 AM
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
            int left = getMax(arr, i, k), right = getMax(arr, k + 1, j);
            min = Math.min(min, left * right + solve(i, k, arr, dp) + 
            solve(k + 1, j, arr, dp));
        }
        return dp[i][j] = min;
    }
    private int getMax(int[] arr, int start, int end) {
        int max = Math.max(arr[start], arr[end]);
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}