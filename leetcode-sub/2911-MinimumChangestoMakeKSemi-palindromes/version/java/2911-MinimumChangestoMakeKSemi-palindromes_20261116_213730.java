// Last updated: 11/16/2026, 9:37:30 PM
1class Solution {
2    private static final int INF = 10000;
3    private int[][] memo;
4    private int[][] cost;
5
6    private int solve(int idx, int k, int n) {
7        if (idx == n || k == 0) return (idx == n && k == 0) ? 0 : INF;
8        if (memo[idx][k] != -1) return memo[idx][k];
9        int res = INF;
10        for (int len = 2; idx + len <= n; len++) {
11            res = Math.min(res, cost[idx][len] + solve(idx + len, k - 1, n));
12        }
13        return memo[idx][k] = res;
14    }
15
16    public int minimumChanges(String s, int k) {
17        int n = s.length();
18        memo = new int[n + 1][k + 1];
19        for (int[] row : memo) Arrays.fill(row, -1);
20        cost = new int[n + 1][n + 1];
21        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE / 2);
22
23        for (int d = 1; d <= n / 2; d++) {
24            int[][] tmp = new int[n + 1][n + 1];
25            for (int len = 2 * d; len <= n; len += d) {
26                for (int idx = 0; idx + len <= n; idx++) {
27                    int ops = 0;
28                    for (int o = 0; o < d; o++) {
29                        if (s.charAt(idx + o) != s.charAt(idx + len - d + o)) ops++;
30                    }
31                    tmp[idx][len] = ops + tmp[idx + d][len - 2 * d];
32                    cost[idx][len] = Math.min(cost[idx][len], tmp[idx][len]);
33                }
34            }
35        }
36        return solve(0, k, n);
37    }
38}