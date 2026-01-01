// Last updated: 1/1/2026, 6:23:04 AM
1class Solution {
2    public int alternatingSubarray(int[] nums) {
3        int n = nums.length, max = -1;
4        int[] dp = new int[n];
5        for (int i = 1; i < n; i++) {
6            dp[i] = (dp[i - 1] > 0 && nums[i] == nums[i - 2]) ? 
7            dp[i - 1] + 1 : (nums[i] - nums[i - 1] == 1) ? 2 : -1;
8            max = Math.max(max, dp[i]);
9        }
10        return max;
11    }
12}