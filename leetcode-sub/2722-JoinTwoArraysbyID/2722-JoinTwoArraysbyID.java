// Last updated: 1/8/2026, 5:21:31 PM
1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int n = nums.length, max = 1;
4        int[][] dp = new int[301][301];
5        for (int i = n - 1; i >= 0; i--) {
6            for (int j = 1; j <= 300; j++) {
7                int diff = Math.abs(nums[i] - j);
8                dp[nums[i]][diff]= Math.max(dp[nums[i]][diff], dp[j][diff] + 1);
9            }
10            for (int j = 1; j <= 300; j++) {
11                dp[nums[i]][j] = Math.max(dp[nums[i]][j], dp[nums[i]][j - 1]);
12            }
13        }
14        for (int i = 0; i <= 300; ++i) {
15            for (int j = 0; j <= 300; ++j) {
16                max = Math.max(max, dp[i][j]);
17            }
18        }
19        return max;
20    }
21}