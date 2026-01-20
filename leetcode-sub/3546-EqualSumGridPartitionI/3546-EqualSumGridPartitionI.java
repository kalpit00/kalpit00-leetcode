// Last updated: 1/19/2026, 11:26:36 PM
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        long rowSum = 0, colSum = 0, sum = 0;
5        long[] preRow = new long[m], preCol = new long[n];
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                preRow[i] += grid[i][j];
9                preCol[j] += grid[i][j];
10            }
11        }
12        for (long r : preRow) {
13            rowSum += r;
14        }
15        colSum = rowSum;
16        for (int i = 0; i < m - 1; i++) {
17            sum += preRow[i];
18            if (rowSum == 2 * sum) {
19                return true;
20            }
21        }
22        sum = 0;
23        for (int j = 0; j < n - 1; j++) {
24            sum += preCol[j];
25            if (colSum == 2 * sum) {
26                return true;
27            }
28        }
29        return false;
30    }
31}