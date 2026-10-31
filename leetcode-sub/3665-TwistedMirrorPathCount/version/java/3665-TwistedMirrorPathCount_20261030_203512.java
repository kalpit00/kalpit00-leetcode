// Last updated: 10/30/2026, 8:35:12 PM
1class Solution {
2
3    public int uniquePaths(int[][] grid) {
4        final int MOD = 1000000007;
5        int m = grid.length;
6        int n = grid[0].length;
7
8        // f[i][j][0]: enter (i, j) by moving down
9        // f[i][j][1]: enter (i, j) by moving right
10        int[][][] f = new int[m][n][2];
11        f[0][0][0] = 1;
12
13        for (int i = 0; i < m; i++) {
14            for (int j = 0; j < n; j++) {
15                if (i > 0) {
16                    if (grid[i - 1][j] == 0) {
17                        f[i][j][0] = (f[i - 1][j][0] + f[i - 1][j][1]) % MOD;
18                    } else {
19                        f[i][j][0] = f[i - 1][j][1];
20                    }
21                }
22
23                if (j > 0) {
24                    if (grid[i][j - 1] == 0) {
25                        f[i][j][1] = (f[i][j - 1][0] + f[i][j - 1][1]) % MOD;
26                    } else {
27                        f[i][j][1] = f[i][j - 1][0];
28                    }
29                }
30            }
31        }
32
33        return (f[m - 1][n - 1][0] + f[m - 1][n - 1][1]) % MOD;
34    }
35}