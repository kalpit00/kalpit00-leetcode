// Last updated: 9/8/2025, 9:01:31 PM
class Solution {
        public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int c = 0; c < n; ++c) {
            dp[0][c] = grid[0][c];
        }
        for (int i = 1; i < m; i++) {
            for (int k = 0; k < n; k++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    min = Math.min(min, 
                    dp[i - 1][j] + moveCost[grid[i - 1][j]][k]);
                }
                dp[i][k] = min + grid[i][k];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;
    }
}