// Last updated: 11/19/2026, 8:42:26 PM
1class Solution {
2    public int maxSelectedElements(int[] nums) {
3        Arrays.sort(nums);
4        int n = nums.length, max = 0;
5        int[] dp = new int[nums[n - 1] + 3];
6        for (int a : nums) {
7            int b = a + 1;
8            dp[b] = Math.max(dp[b], dp[b - 1] + 1);
9            dp[a] = Math.max(dp[a], dp[a - 1] + 1);
10            max = Math.max(max, Math.max(dp[a], dp[b]));
11        }
12        return max;
13    }
14}