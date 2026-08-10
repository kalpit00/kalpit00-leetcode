// Last updated: 8/9/2026, 11:26:53 PM
1class Solution {
2    static final int MAX = 100000;
3    static final boolean[] dp = new boolean[MAX + 1];
4
5    static {
6        for (int i = 0; i <= MAX; i++) {
7            if (dp[i]) continue;
8
9            for (int j = 1; j * j <= MAX - i; j++)
10                dp[i + j * j] = true;
11        }
12    }
13
14    public boolean winnerSquareGame(int n) { return dp[n]; }
15}