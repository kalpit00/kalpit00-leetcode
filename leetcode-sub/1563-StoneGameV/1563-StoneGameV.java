// Last updated: 8/17/2026, 6:40:45 AM
1class Solution {
2    public int stoneGameV(int[] nums) {
3        int n = nums.length;
4        Long[][] dp = new Long[n][n];
5        long[] pre = new long[n + 1];
6        for (int i = 0; i < n; i++) {
7            pre[i + 1] = pre[i] + nums[i];
8        }
9        return (int) solve(0, n - 1, n, nums, dp, pre);   
10    }
11	private long solve(int i, int j, int n, int[] nums, 
12    Long[][] dp, long[] pre) {
13        if (i >= j) {
14            return 0;
15        }
16        if (dp[i][j] != null) {
17            return dp[i][j];
18        }
19        long max = Long.MIN_VALUE;
20        for (int k = i + 1; k <= j; k++) {
21            long left = pre[k] - pre[i];
22            long right = pre[j + 1] - pre[k];
23            if (left < right) {
24                max = Math.max(max, left + solve(i, k - 1, n, nums, dp, pre));
25            }
26            else if (left > right) {
27                max = Math.max(max, right + solve(k, j, n, nums, dp, pre));
28            }
29            else {
30                max = Math.max(max, left + solve(i, k - 1, n, nums, dp, pre));
31                max = Math.max(max, right + solve(k, j, n, nums, dp, pre));
32            }
33        }
34        return dp[i][j] = max;
35    }
36}