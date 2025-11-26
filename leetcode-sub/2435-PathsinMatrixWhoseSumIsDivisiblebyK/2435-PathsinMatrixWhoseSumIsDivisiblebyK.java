// Last updated: 11/25/2025, 7:17:55 PM
class Solution {
    int mod = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m + 1][n + 1][k + 1];
        return dfs(grid, m - 1, n - 1, 0, k, m, n, dp);
    }
    private int dfs(int[][] grid, int i, int j, int sum, int k, int m, int n, Integer[][][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        int s = (sum + grid[i][j]) % k;
        if (i == 0 && j == 0) {
            return s == 0 ? 1 : 0;
        }
        if (dp[i][j][s] != null) {
            return dp[i][j][s];
        }
        int left = dfs(grid, i, j - 1, s, k, m, n, dp);
        int up = dfs(grid, i - 1, j, s, k, m, n, dp);
        return dp[i][j][s] = (left + up) % mod;
    }
}