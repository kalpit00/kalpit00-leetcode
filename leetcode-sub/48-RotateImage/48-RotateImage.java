// Last updated: 5/3/2026, 9:02:44 PM
1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4        int[][] grid = new int[n][n];
5        for (int i = 0; i < n; i++) {
6            for (int j = 0; j < n; j++) {
7                grid[j][n - i - 1] = matrix[i][j];
8            }
9        }
10        for (int i = 0; i < n; i++) {
11            for (int j = 0; j < n; j++) {
12                matrix[i][j] = grid[i][j];
13            }
14        }
15    }
16}