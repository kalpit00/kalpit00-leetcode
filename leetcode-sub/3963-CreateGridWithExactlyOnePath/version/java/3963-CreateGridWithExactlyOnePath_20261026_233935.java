// Last updated: 10/26/2026, 11:39:35 PM
1class Solution {
2    public String[] createGrid(int m, int n) {
3        char[][] grid = new char[m][n];
4        String[] res = new String[m];
5        for (int i = 0; i < m; i++) {
6            for (int j = 0; j < n; j++) {
7                grid[i][j] = i == 0 || j == n - 1 ? '.' : '#';
8            }
9            res[i] = String.valueOf(grid[i]);
10        }
11        return res;
12    }
13}