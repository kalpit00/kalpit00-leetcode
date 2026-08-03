// Last updated: 8/2/2026, 9:03:17 PM
1class Solution {
2    public String stoneGameIII(int[] stoneValue) {
3        int n = stoneValue.length;
4        int[] dp = new int[4];
5        for (int i = n - 1; i >= 0; i--) {
6            dp[i % 4] = stoneValue[i] - dp[(i + 1) % 4];
7            if (i + 2 <= n) {
8                dp[i % 4] = Math.max(dp[i % 4], stoneValue[i] + stoneValue[i + 1]
9                    - dp[(i + 2) % 4]);
10            }
11            if (i + 3 <= n) {
12                dp[i % 4] = Math.max(dp[i % 4], stoneValue[i] + stoneValue[i + 1]
13                    + stoneValue[i + 2] - dp[(i + 3) % 4]);
14            }
15        }
16        if (dp[0] > 0) {
17            return "Alice";
18        }
19        if (dp[0] < 0) {
20            return "Bob";
21        }
22        return "Tie";
23    }
24}