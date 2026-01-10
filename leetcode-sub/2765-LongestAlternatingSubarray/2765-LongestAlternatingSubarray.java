// Last updated: 1/10/2026, 6:05:16 PM
1class Solution {
2    public int deleteGreatestValue(int[][] grid) {
3        int m = grid.length, n = grid[0].length, sum = 0;
4        for (int i = 0; i < m; i++) {
5            Arrays.sort(grid[i]);
6        }
7        for (int j = n - 1; j >= 0; j--) {
8            int max = 0;
9            for (int i = 0; i < m; i++) {
10                max = Math.max(max, grid[i][j]);
11            }
12            sum += max;
13        }
14        return sum;
15    }
16}