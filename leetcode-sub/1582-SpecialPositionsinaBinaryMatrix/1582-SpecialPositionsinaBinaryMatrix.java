// Last updated: 3/3/2026, 9:16:01 PM
1class Solution {
2    public int numSpecial(int[][] mat) {
3        int m = mat.length, n = mat[0].length, count = 0;
4        int[] row = new int[m], col = new int[n];
5        for (int i = 0; i < m; i++) {
6            for (int j = 0; j < n; j++) {
7                row[i] += mat[i][j];
8                col[j] += mat[i][j];
9            }
10        }
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13                count += mat[i][j] == 1 && row[i] == 1 && col[j] == 1 ? 1 : 0;
14            }
15        }
16        return count;
17    }
18}