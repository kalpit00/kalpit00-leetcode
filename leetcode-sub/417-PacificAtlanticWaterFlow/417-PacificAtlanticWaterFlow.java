// Last updated: 10/4/2025, 11:12:25 PM
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0, m, n, pacific, -1);
            dfs(grid, i, n - 1, m, n, atlantic, -1);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j, m, n, pacific, -1);
            dfs(grid, m - 1, j, m, n, atlantic, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int r, int c, int m, int n, 
    boolean[][] visited, int prev) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || 
        grid[r][c] < prev) {
            return;
        }
        visited[r][c] = true;
        dfs(grid, r - 1, c, m, n, visited, grid[r][c]);
        dfs(grid, r + 1, c, m, n, visited, grid[r][c]);
        dfs(grid, r, c - 1, m, n, visited, grid[r][c]);
        dfs(grid, r, c + 1, m, n, visited, grid[r][c]);
    }
}
