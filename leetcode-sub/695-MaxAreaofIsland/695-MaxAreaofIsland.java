// Last updated: 4/18/2026, 2:53:50 PM
1class Solution {
2    public int maxAreaOfIsland(int[][] grid) {
3        int max = 0, m = grid.length, n = grid[0].length;
4        for (int i = 0; i < m; i++) {
5            for (int j = 0; j < n; j++) {
6                if (grid[i][j] == 1) {
7                    int size = dfs(grid, i, j, m, n);
8                    max = Math.max(size, max);
9                }
10            }
11        }
12        return max;
13    }
14    private int dfs(int[][] grid, int r, int c, int m, int n) {
15        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
16            return 0;
17        }
18        grid[r][c] = 0;
19        int size = 1;
20        size += dfs(grid, r - 1, c, m, n);
21        size += dfs(grid, r + 1, c, m, n);
22        size += dfs(grid, r, c - 1, m, n);
23        size += dfs(grid, r, c + 1, m, n);
24        return size;
25    }
26}