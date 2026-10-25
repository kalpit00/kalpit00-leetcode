// Last updated: 10/24/2026, 9:50:10 PM
1class Solution {
2    int oldColor = -1, newColor = -1;
3    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
4        if (grid[sr][sc] == color) {
5            return grid;
6        }
7        oldColor = grid[sr][sc];
8        newColor = color;
9        int m = grid.length, n = grid[0].length;
10        dfs(grid, sr, sc, m, n);
11        return grid;
12    }
13    private void dfs(int[][] grid, int r, int c, int m, int n) {
14        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != oldColor) {
15            return;
16        }
17        grid[r][c] = newColor;
18        dfs(grid, r - 1, c, m, n);
19        dfs(grid, r + 1, c, m, n);
20        dfs(grid, r, c - 1, m, n);
21        dfs(grid, r, c + 1, m, n);
22    }
23}