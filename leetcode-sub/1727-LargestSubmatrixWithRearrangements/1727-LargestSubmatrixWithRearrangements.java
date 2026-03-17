// Last updated: 3/16/2026, 8:41:16 PM
1class Solution {
2    public int largestSubmatrix(int[][] matrix) {
3        int m = matrix.length, n = matrix[0].length, max = Integer.MIN_VALUE;
4        for (int i = 0; i < m; i++) {
5            for (int j = 0; j < n; j++) {
6                if (matrix[i][j] != 0 && i > 0) {
7                    matrix[i][j] += matrix[i - 1][j];
8                }
9            }
10            int[] row = matrix[i].clone();
11            Arrays.sort(row);
12            for (int k = 0; k < n; k++) {
13                max = Math.max(max, row[k] * (n - k));
14            }
15        }
16        return max;
17    }
18}