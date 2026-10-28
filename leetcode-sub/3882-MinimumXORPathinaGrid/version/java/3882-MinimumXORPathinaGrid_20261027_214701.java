// Last updated: 10/27/2026, 9:47:01 PM
1class Solution {
2
3    public int minCost(int[][] grid) {
4        int m = grid.length;
5        int n = grid[0].length;
6
7        boolean[][] dp = new boolean[n][1024];
8        boolean[] next = new boolean[1024];
9
10        dp[0][grid[0][0]] = true;
11
12        for (int i = 0; i < m; i++) {
13            for (int j = 0; j < n; j++) {
14                if (i == 0 && j == 0) {
15                    continue;
16                }
17
18                int value = grid[i][j];
19                Arrays.fill(next, false);
20
21                for (int k = 0; k < 1024; k++) {
22                    if (dp[j][k] || (j > 0 && dp[j - 1][k])) {
23                        next[k ^ value] = true;
24                    }
25                }
26
27                System.arraycopy(next, 0, dp[j], 0, 1024);
28            }
29        }
30
31        for (int k = 0; k < 1024; k++) {
32            if (dp[n - 1][k]) {
33                return k;
34            }
35        }
36
37        return -1;
38    }
39}