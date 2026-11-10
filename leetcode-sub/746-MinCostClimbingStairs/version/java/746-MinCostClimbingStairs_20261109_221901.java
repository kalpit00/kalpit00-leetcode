// Last updated: 11/9/2026, 10:19:01 PM
1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int n = cost.length;
4        for (int i = 2; i < n; i++) {
5            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
6        }
7        return Math.min(cost[n - 1], cost[n - 2]);
8    }
9}