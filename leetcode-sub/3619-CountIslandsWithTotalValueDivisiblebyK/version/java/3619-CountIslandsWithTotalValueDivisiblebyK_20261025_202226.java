// Last updated: 10/25/2026, 8:22:26 PM
1class Solution {
2    public int countIslands(int[][] grid, int k) {
3        int count = 0, m = grid.length, n = grid[0].length;
4        for (int i = 0; i < m; i++) {
5            for (int j = 0; j < n; j++) {
6                if (grid[i][j] > 0) {
7                    long sum = dfs(grid, i, j, m, n);
8                    count += sum % k == 0 ? 1 : 0;
9                }
10            }
11        }
12        return count;
13    }
14    private long dfs(int[][] grid, int r, int c, int m, int n) {
15        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] <= 0) {
16            return 0;
17        }
18        long sum = grid[r][c];
19        grid[r][c] = -1;
20        sum += dfs(grid, r - 1, c, m, n);
21        sum += dfs(grid, r + 1, c, m, n);
22        sum += dfs(grid, r, c - 1, m, n);
23        sum += dfs(grid, r, c + 1, m, n);
24        return sum;
25    }
26}