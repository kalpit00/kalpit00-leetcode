// Last updated: 1/1/2026, 12:40:22 AM
1class Solution {
2    public int maxTurbulenceSize(int[] nums) {
3        int n = nums.length, max = 1;
4        int[][] dp = new int[n][2];
5        for (int i = 0; i < n; i++) {
6            dp[i][0] = dp[i][1] = 1;
7        }
8        for (int i = 1; i < n; i++) {
9            if (nums[i] > nums[i - 1]) {
10                dp[i][1] = dp[i - 1][0] + 1;
11            }
12            else if (nums[i] < nums[i - 1]) {
13                dp[i][0] = dp[i - 1][1] + 1;
14            }
15        }
16        for (int i = 0; i < n; i++) {
17            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
18        }
19        return max;
20    }
21}