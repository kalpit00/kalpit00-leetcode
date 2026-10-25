// Last updated: 10/24/2026, 9:42:37 PM
1class Solution {
2    public int closedIsland(int[][] grid) {
3        int count = 0, m = grid.length, n = grid[0].length;
4        for (int i = 0; i < m; i++) {
5            for (int j = 0; j < n; j++) {
6                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
7                    dfs(grid, i, j, m, n);
8                }
9            }
10        }
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13                if (grid[i][j] == 0) {
14                    count++;
15                    dfs(grid, i, j, m, n);
16                }
17            }
18        }
19        return count;
20    }
21    private void dfs(int[][] grid, int r, int c, int m, int n) {
22        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 1) {
23            return;
24        }
25        grid[r][c] = 1;
26        dfs(grid, r - 1, c, m, n);
27        dfs(grid, r + 1, c, m, n);
28        dfs(grid, r, c - 1, m, n);
29        dfs(grid, r, c + 1, m, n);
30    }
31}