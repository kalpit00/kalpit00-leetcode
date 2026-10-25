// Last updated: 10/24/2026, 9:58:19 PM
1class Solution {
2    public int numEnclaves(int[][] grid) {
3        int count = 0, m = grid.length, n = grid[0].length;
4        for (int i = 0; i < m; i++) {
5            for (int j = 0; j < n; j++) {
6                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
7                    if (grid[i][j] == 1) dfs(grid, i, j, m, n);
8                }
9            }
10        }
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13                if (grid[i][j] == 1) {
14                    count++;
15                }
16            }
17        }
18        return count;
19    }
20    private void dfs(int[][] grid, int r, int c, int m, int n) {
21        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
22            return;
23        }
24        grid[r][c] = 0;
25        dfs(grid, r - 1, c, m, n);
26        dfs(grid, r + 1, c, m, n);
27        dfs(grid, r, c - 1, m, n);
28        dfs(grid, r, c + 1, m, n);
29    }
30}