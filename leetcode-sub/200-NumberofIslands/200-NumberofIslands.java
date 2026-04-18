// Last updated: 4/18/2026, 2:47:18 PM
1class Solution {
2    public int numIslands(char[][] grid) {
3        int count = 0, m = grid.length, n = grid[0].length;
4        for (int i = 0; i < m; i++) {
5            for (int j = 0; j < n; j++) {
6                if (grid[i][j] == '1') {
7                    count++;
8                    dfs(grid, i, j, m, n);
9                }
10            }
11        }
12        return count;
13    }
14    private void dfs(char[][] grid, int r, int c, int m, int n) {
15        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
16            return;
17        }
18        grid[r][c] = '0';
19        dfs(grid, r - 1, c, m, n);
20        dfs(grid, r + 1, c, m, n);
21        dfs(grid, r, c - 1, m, n);
22        dfs(grid, r, c + 1, m, n);
23    }
24}