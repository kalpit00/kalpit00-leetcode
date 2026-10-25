// Last updated: 10/24/2026, 9:41:20 PM
1class Solution {
2    public int closedIsland(int[][] grid) {
3        int m = grid.length, n = grid[0].length, count = 0;
4        for (int i = 0; i < m; i++) {
5            for (int j = 0; j < n; j++) {
6                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && 
7                grid[i][j] == 0) {
8                    floodfill(grid, i, j, 0, 1, m, n);
9                }
10            }
11        }
12        for (int i = 0; i < m; i++) {
13            for (int j = 0; j < n; j++) {
14                if (grid[i][j] == 0) {
15                    floodfill(grid, i, j, 0, 1, m, n);
16                    count++;
17                }
18            }
19        }
20        return count;
21    }
22    private void floodfill(int[][] grid, int r, int c, int color, int newColor, int m, int n) {
23        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != color) {
24            return;
25        }
26        grid[r][c] = newColor;
27        floodfill(grid, r+1, c, color, newColor, m, n);
28        floodfill(grid, r-1, c, color, newColor, m, n);
29        floodfill(grid, r, c+1, color, newColor, m, n);
30        floodfill(grid, r, c-1, color, newColor, m, n);
31    }
32}