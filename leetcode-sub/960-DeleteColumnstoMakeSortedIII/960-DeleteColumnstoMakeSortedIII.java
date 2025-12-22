// Last updated: 12/21/2025, 9:22:21 PM
1class Solution {
2    public int minDeletionSize(String[] A) {
3        int W = A[0].length();
4        int[] dp = new int[W];
5        Arrays.fill(dp, 1);
6        for (int i = W-2; i >= 0; --i)
7            search: for (int j = i+1; j < W; ++j) {
8                for (String row: A)
9                    if (row.charAt(i) > row.charAt(j))
10                        continue search;
11
12                dp[i] = Math.max(dp[i], 1 + dp[j]);
13            }
14
15        int kept = 0;
16        for (int x: dp)
17            kept = Math.max(kept, x);
18        return W - kept;
19    }
20}