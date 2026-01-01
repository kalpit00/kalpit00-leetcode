// Last updated: 1/1/2026, 6:16:37 AM
1class Solution {
2    public int alternatingSubarray(int[] nums) {
3        int n = nums.length, max = -1;
4        Integer[] dp = new Integer[n];
5        for (int i = 1; i < n; i++) {
6            if (dp[i - 1] != null && nums[i] == nums[i - 2]) {
7                dp[i] = dp[i - 1] + 1;
8            }
9            else {
10                dp[i] = nums[i] - nums[i - 1] == 1 ? 2 : null;
11            }
12        }
13        for (int i = 0; i < n; i++) {
14            if (dp[i] == null) continue;
15            max = Math.max(max, dp[i]);
16        }
17        return max;
18    }
19}