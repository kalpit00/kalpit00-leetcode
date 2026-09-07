// Last updated: 9/7/2026, 12:20:18 AM
1class Solution {
2    public int distinctSubseqII(String S) {
3        int MOD = 1_000_000_007;
4        int N = S.length();
5        int[] dp = new int[N+1];
6        dp[0] = 1;
7
8        int[] last = new int[26];
9        Arrays.fill(last, -1);
10
11        for (int i = 0; i < N; ++i) {
12            int x = S.charAt(i) - 'a';
13            dp[i+1] = dp[i] * 2 % MOD;
14            if (last[x] >= 0)
15                dp[i+1] -= dp[last[x]];
16            dp[i+1] %= MOD;
17            last[x] = i;
18        }
19
20        dp[N]--;
21        if (dp[N] < 0) dp[N] += MOD;
22        return dp[N];
23    }
24}