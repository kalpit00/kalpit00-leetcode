// Last updated: 5/9/2026, 8:04:24 PM
1class Solution {
2    public int maximumJumps(int[] nums, int target) {
3        int n = nums.length;
4        Integer[] dp = new Integer[n];
5        return solve(nums, 0, n, dp, target);
6    }
7    private int solve(int[] nums, int i, int n, Integer[] dp, int target) {
8        if (i == n - 1) {
9            return 0;
10        }
11        if (i >= n) {
12            return -1;
13        }
14        if (dp[i] != null) {
15            return dp[i];
16        }
17        int max = -1;
18        for (int j = i + 1; j < n; j++) {
19            if (Math.abs(nums[j] - nums[i]) <= target) {
20                int jumps = solve(nums, j, n, dp, target);
21                max = (jumps != -1) ? 
22                Math.max(max, jumps + 1) : max;
23            }
24        }
25        return dp[i] = max;
26    }
27}