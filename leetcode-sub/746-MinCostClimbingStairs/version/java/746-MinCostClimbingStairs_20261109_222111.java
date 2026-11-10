// Last updated: 11/9/2026, 10:21:11 PM
1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int n = cost.length;
4        int[] dp = new int[n];
5        dp[0] = cost[0];
6        dp[1] = cost[1];
7        for (int i = 2; i < n; i++) {
8            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
9        }
10        return Math.min(dp[n - 1], dp[n - 2]);
11    }
12}