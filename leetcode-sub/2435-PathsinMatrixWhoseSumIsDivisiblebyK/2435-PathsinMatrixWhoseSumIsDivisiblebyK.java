// Last updated: 11/25/2025, 7:18:25 PM
class Solution {
    int mod = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m + 1][n + 1][k + 1];
        return dfs(grid, 0, 0, 0, k, m, n, dp);
    }
    private int dfs(int[][] grid, int i, int j, int sum, int k, int m, int n, Integer[][][] dp) {
        if (i == m || j == n) {
            return 0;
        }
        int s = (sum + grid[i][j]) % k;
        if (i == m - 1 && j == n - 1) {
            return s == 0 ? 1 : 0;
        }
        if (dp[i][j][s] != null) {
            return dp[i][j][s];
        }
        int right = dfs(grid, i, j + 1, s, k, m, n, dp);
        int down = dfs(grid, i + 1, j, s, k, m, n, dp);
        return dp[i][j][s] = (right + down) % mod;
    }
}