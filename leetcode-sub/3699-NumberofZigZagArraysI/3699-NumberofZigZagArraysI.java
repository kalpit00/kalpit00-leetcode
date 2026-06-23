// Last updated: 6/22/2026, 8:04:15 PM
1class Solution {
2    public int zigZagArrays(int n, int l, int r) {
3        int MOD = 1_000_000_007;
4        r -= l;
5        int[] dp = new int[r + 1];
6        Arrays.fill(dp, 1);
7        for (int i = 1; i < n; i++) {
8            int pre = 0, pre2;
9            if ((i & 1) == 1) {
10                for (int v = 0; v <= r; v++) {
11                    pre2 = pre + dp[v];
12                    dp[v] = pre;
13                    pre = pre2 % MOD;
14                }
15            } else {
16                for (int v = r; v >= 0; v--) {
17                    pre2 = pre + dp[v];
18                    dp[v] = pre;
19                    pre = pre2 % MOD;
20                }
21            }
22        }
23        int res = 0;
24        for (int v : dp)
25            res = (res + v) % MOD;
26        return res * 2 % MOD;
27    }
28}