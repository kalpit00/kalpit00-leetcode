// Last updated: 1/1/2026, 6:17:26 AM
1class Solution {
2    public int alternatingSubarray(int[] nums) {
3        int n = nums.length, max = -1;
4        int[] dp = new int[n];
5        Arrays.fill(dp, -1);
6        for (int i = 1; i < n; i++) {
7            if (dp[i - 1] != -1 && nums[i] == nums[i - 2]) {
8                dp[i] = dp[i - 1] + 1;
9            }
10            else {
11                dp[i] = nums[i] - nums[i - 1] == 1 ? 2 : -1;
12            }
13        }
14        for (int i = 0; i < n; i++) {
15            max = Math.max(max, dp[i]);
16        }
17        return max;
18    }
19}