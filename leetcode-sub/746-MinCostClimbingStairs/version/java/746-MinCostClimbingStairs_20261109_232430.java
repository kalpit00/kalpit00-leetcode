// Last updated: 11/9/2026, 11:24:30 PM
1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int n = cost.length;
4        Integer[] dp = new Integer[n];
5        return Math.min(solve(0, cost, dp, n), solve(1, cost, dp, n));
6    }
7
8    private int solve(int i, int[] cost, Integer[] dp, int n) {
9        if (i >= n) return 0;
10        if (dp[i] != null) return dp[i];
11        return dp[i] = cost[i] + Math.min(solve(i + 1, cost, dp, n), 
12        solve(i + 2, cost, dp, n));
13    }
14}