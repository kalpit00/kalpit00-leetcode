// Last updated: 11/9/2026, 11:37:24 PM
1class Solution {
2    public int climbStairs(int n, int[] cost) {
3        Integer[] dp = new Integer[n + 1];
4        return solve(0, cost, dp, n);
5    }
6
7    private int solve(int i, int[] cost, Integer[] dp, int n) {
8        if (i >= n) return 0;
9        if (dp[i] != null) return dp[i];
10        int min = Integer.MAX_VALUE;
11        for (int j = 1; j <= 3; j++) {
12            if (i + j > n) continue;
13            min = Math.min(min, solve(i + j, cost, dp, n) + cost[i + j - 1] + (j) * (j));
14        }
15        return dp[i] = min;
16    }
17}