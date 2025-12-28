// Last updated: 12/28/2025, 1:16:34 AM
1class Solution {
2    public int countNegatives(int[][] grid) {
3        int m = grid.length, n = grid[0].length, count = 0;
4        for (int i = 0; i < m; i++) {
5            for (int j = 0; j < n; j++) {
6                count += grid[i][j] < 0 ? 1 : 0;
7            }
8        }
9        return count;
10    }
11}