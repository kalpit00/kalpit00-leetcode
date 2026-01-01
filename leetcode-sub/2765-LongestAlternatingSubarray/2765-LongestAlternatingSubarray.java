// Last updated: 1/1/2026, 6:20:26 AM
1class Solution {
2    public int alternatingSubarray(int[] nums) {
3        int n = nums.length, max = -1;
4        int[] dp = new int[n];
5        Arrays.fill(dp, -1);
6        for (int i = 1; i < n; i++) {
7            dp[i] = (dp[i - 1] != -1 && nums[i] == nums[i - 2]) ? dp[i - 1] + 1
8            : (nums[i] - nums[i - 1] == 1) ? 2 : -1;
9            max = Math.max(max, dp[i]);
10        }
11        return max;
12    }
13}