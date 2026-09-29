// Last updated: 9/29/2026, 3:57:22 AM
1class Solution {
2
3    public boolean hasValidPath(char[][] grid) {
4        int n = grid.length;
5        int m = grid[0].length;
6        int pathLen = n + m - 1;
7
8        if (pathLen % 2 == 1) {
9            return false;
10        }
11        if (grid[0][0] != '(' || grid[n - 1][m - 1] != ')') {
12            return false;
13        }
14
15        boolean[][][] dp = new boolean[n][m][pathLen + 1];
16
17        dp[0][0][1] = true;
18
19        for (int i = 0; i < n; ++i) {
20            for (int j = 0; j < m; ++j) {
21                int change = grid[i][j] == '(' ? 1 : -1;
22
23                if (i > 0) {
24                    for (int balance = 0; balance <= pathLen; ++balance) {
25                        if (!dp[i - 1][j][balance]) {
26                            continue;
27                        }
28
29                        int next = balance + change;
30
31                        if (next >= 0) {
32                            dp[i][j][next] = true;
33                        }
34                    }
35                }
36
37                if (j > 0) {
38                    for (int balance = 0; balance <= pathLen; ++balance) {
39                        if (!dp[i][j - 1][balance]) {
40                            continue;
41                        }
42
43                        int next = balance + change;
44
45                        if (next >= 0) {
46                            dp[i][j][next] = true;
47                        }
48                    }
49                }
50            }
51        }
52
53        return dp[n - 1][m - 1][0];
54    }
55}