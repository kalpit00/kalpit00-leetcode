// Last updated: 11/11/2025, 12:52:23 AM
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int k = strs.length, i = 0;
        int[][] nums = new int[k][2];
        for (String s : strs) {
            nums[i++] = helper(s);
        }
        Integer[][][] dp = new Integer[k][m + 1][n + 1];
        return solve(0, k, 0, 0, m, n, nums, dp);
    }
    private int solve(int i, int k, int a, int b, int m, int n, 
    int[][] nums, Integer[][][] dp) {
        if (i >= k) {
            return 0;
        }
        if (dp[i][a][b] != null) {
            return dp[i][a][b];
        }
        int notTake = solve(i + 1, k, a, b, m, n, nums, dp);
        int take = 0;
        if (a + nums[i][0] <= m && b + nums[i][1] <= n) {
            take += 1 + solve(i + 1, k, a + nums[i][0], b + nums[i][1], 
            m, n, nums, dp);
        }
        return dp[i][a][b] = Math.max(take, notTake);
    }
    private int[] helper(String s) {
        int n = s.length(), count = 0;
        for (char c : s.toCharArray()) {
            count += c == '0' ? 1 : 0;
        }
        return new int[]{count, n - count};
    }
}