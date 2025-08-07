// Last updated: 8/6/2025, 9:16:19 PM
class Solution {
    public int maxCollectedFruits(int[][] grid) {
        int n = grid.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[i][i]; // sum all L-R diagonal cells for 0-0 guy
            grid[i][i] = 0; // set it to 0 so its irrelevant for other 2
        }
        Integer[][] dp1 = new Integer[n][n], dp2 = new Integer[n][n];
        return sum + solve(n - 1, 0, true, n, grid, dp1) + 
        solve(0, n - 1, false, n, grid, dp2);
    }
    private int solve(int i, int j, boolean flag, int n, int[][] grid, 
    Integer[][] dp) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return Integer.MIN_VALUE;
        }
        if (i == n - 1 && j == n - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int sum = grid[i][j];
        int max = Integer.MIN_VALUE;
        for (int d = -1; d <= 1; d++) {
            if (flag) {
                max = Math.max(max, solve(i + d, j + 1, flag, n, grid, dp));
            }
            else {
                max = Math.max(max, solve(i + 1, j + d, flag, n, grid, dp));
            }
        }
        sum += max;
        return dp[i][j] = sum;
    }
}