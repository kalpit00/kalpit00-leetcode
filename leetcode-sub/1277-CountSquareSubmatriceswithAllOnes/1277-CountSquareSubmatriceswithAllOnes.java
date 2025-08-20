// Last updated: 8/19/2025, 8:30:52 PM
class Solution {
    public int countSquares(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        Integer[][] dp = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += solve(i, j, grid, dp);
            }
        }
        return count;
    }

    public int solve(int i, int j, int[][] grid, Integer[][] dp) {
        int m = grid.length, n = grid[0].length;
        if (i >= m || j >= n) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int right = solve(i, j + 1, grid, dp);
        int diagonal = solve(i + 1, j + 1, grid, dp);
        int below = solve(i + 1, j, grid, dp);
        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, below));
    }
}