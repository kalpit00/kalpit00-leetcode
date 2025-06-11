// Last updated: 6/11/2025, 12:45:27 AM
class Solution {
    public int mergeStones(int[] nums, int p) {
        int n = nums.length;
        if ((n - 1) % (p - 1) != 0) {
            return -1;
        }
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        Integer[][] dp = new Integer[n + 1][n + 1];
        return solve(0, n - 1, n, p, pre, dp);
    }
    private int solve(int i, int j, int n, int p, int[] pre, Integer[][] dp) {
        if (i + p - 1 > j) {
            return 0; // k in [i, j] with k += p - 1 steps!
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k += p - 1) {
            min = Math.min(min, solve(i, k, n, p, pre, dp) + 
            solve(k + 1, j, n, p, pre, dp));
        }
        min += (j - i) % (p - 1) == 0 ? pre[j + 1] - pre[i] : 0;
        return dp[i][j] = min;
    }
}