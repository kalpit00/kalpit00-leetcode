// Last updated: 3/23/2026, 3:11:44 AM
1class Solution {
2    public int maxProductPath(int[][] grid) {
3        int m = grid.length, n = grid[0].length, mod = 1000000007;
4        long[][][] dp = new long[m + 1][n + 1][2];
5        for (int i = 0; i <= m; i++) {
6            for (int j = 0; j <= n; j++) {
7                dp[i][j][0] = Long.MIN_VALUE;
8                dp[i][j][1] = Long.MAX_VALUE;
9            }
10        }
11        dp[1][1][0] = dp[1][1][1] = grid[0][0];
12        for (int i = 1; i <= m; i++) {
13            for (int j = 1; j <= n; j++) {
14                if (i == 1 && j == 1) continue;
15                long max = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) * 
16                grid[i - 1][j - 1];
17                long min = Math.min(dp[i - 1][j][1], dp[i][j - 1][1]) * 
18                grid[i - 1][j - 1];
19                dp[i][j][0] = Math.max(max, min);
20                dp[i][j][1] = Math.min(max, min);
21            }
22        }
23        return dp[m][n][0] < 0 ? -1 : (int) (dp[m][n][0] % mod);
24    }
25}
26