// Last updated: 4/30/2026, 11:17:26 PM
1class Solution {
2    public int maxRotateFunction (int[] nums) {
3        int n = nums.length, sum = 0, prod = 0;
4        int[] dp = new int[n];
5        for (int i = 0; i < n; i++) {
6            sum += nums[i];
7            prod += i * nums[i];
8        }
9        dp[0] = prod;
10        int max = dp[0];
11        for (int i = 1; i < n; i++) {
12            dp[i] = dp[i - 1] + sum - n * nums[n - i];
13            max = Math.max(max, dp[i]);
14        }
15        return max;
16    }
17}