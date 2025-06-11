// Last updated: 6/11/2025, 2:54:03 AM
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer[] dp = new Integer[n];
        return solve(0, n, arr, k, dp);
    }

    private int solve(int i, int n, int[] arr, int k, Integer[] dp) {
        if (i == n) return 0;
        if (dp[i] != null) return dp[i];
        int maxSum = 0;
        int maxInPartition = 0;
        for (int len = 1; len <= k && i + len - 1 < n; len++) {
            maxInPartition = Math.max(maxInPartition, arr[i + len - 1]);
            int cost = maxInPartition * len + solve(i + len, n, arr, k, dp);
            maxSum = Math.max(maxSum, cost);
        }
        return dp[i] = maxSum;
    }
}
