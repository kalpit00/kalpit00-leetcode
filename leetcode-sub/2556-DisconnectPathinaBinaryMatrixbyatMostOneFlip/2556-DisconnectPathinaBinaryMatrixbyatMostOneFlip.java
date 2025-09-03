// Last updated: 9/3/2025, 1:57:35 PM
class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dfs(grid, 0, 0, m, n);
        grid[0][0] = 1;
        return !dfs(grid, 0, 0, m, n);
    }
    private boolean dfs(int[][] grid, int r, int c, int m, int n) {
        if (r == m - 1 && c == n - 1) {
            return true;
        }
        if (r >= m || c >= n || r < 0 || c < 0 || grid[r][c] == 0) {
            return false;
        }
        grid[r][c] = 0;
        return dfs(grid, r + 1, c, m, n) || dfs(grid, r, c + 1, m, n);
    }
}