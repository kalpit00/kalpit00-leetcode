// Last updated: 11/9/2026, 10:22:20 PM
1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int n = cost.length;
4        Integer[] dp = new Integer[n];
5        return Math.min(solve(n - 1, cost, dp), solve(n - 2, cost, dp));
6    }
7
8    private int solve(int i, int[] cost, Integer[] dp) {
9        if (i == 0 || i == 1) return cost[i];
10        if (dp[i] != null) return dp[i];
11        return dp[i] = cost[i] + Math.min(solve(i - 1, cost, dp), 
12        solve(i - 2, cost, dp));
13    }
14}