// Last updated: 3/9/2026, 8:05:54 PM
1class Solution {
2    public int numberOfStableArrays(int zero, int one, int limit) {
3        int mod = 1000000007;
4        int[][][] dp = new int[zero + 1][one + 1][2];
5        for (int i = 1; i <= Math.min(zero, limit); i++) {
6            dp[i][0][0] = 1;
7        }
8        for (int i = 1; i <= Math.min(one, limit); i++) {
9            dp[0][i][1] = 1;
10        }
11        for (int i = 1; i <= zero; i++) {
12            for (int j = 1; j <= one; j++) {
13                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % mod;
14                if (i > limit){
15                    dp[i][j][0] = (dp[i][j][0] + mod - dp[i - limit - 1][j][1]) % mod;
16                }
17                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % mod;
18                if (j > limit){
19                    dp[i][j][1] = (dp[i][j][1] + mod - dp[i][j - limit - 1][0]) % mod;
20                }
21            }
22        }
23        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
24    }
25}