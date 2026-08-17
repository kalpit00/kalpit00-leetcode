// Last updated: 8/17/2026, 6:37:17 AM
1class Solution {
2    public int stoneGameV(int[] nums) {
3        int n = nums.length;
4        Long[][] dp = new Long[n][n];
5        long[] pre = new long[n];
6        pre[0] = nums[0];
7        for (int i = 1; i < n; i++) {
8            pre[i] = pre[i - 1] + nums[i];
9        }
10        return (int) solve(0, n - 1, n, nums, dp, pre);   
11    }
12	private long solve(int i, int j, int n, int[] nums, 
13    Long[][] dp, long[] pre) {
14        if (i >= j) {
15            return 0;
16        }
17        if (dp[i][j] != null) {
18            return dp[i][j];
19        }
20        long max = Long.MIN_VALUE;
21        for (int k = i + 1; k <= j; k++) {
22            long left = i > 0 ? pre[k - 1] - pre[i - 1] : pre[k - 1];
23            long right = k > 0 ? pre[j] - pre[k - 1] : pre[j];
24            if (left < right) {
25                max = Math.max(max, left + solve(i, k - 1, n, nums, dp, pre));
26            }
27            else if (left > right) {
28                max = Math.max(max, right + solve(k, j, n, nums, dp, pre));
29            }
30            else {
31                max = Math.max(max, left + solve(i, k - 1, n, nums, dp, pre));
32                max = Math.max(max, right + solve(k, j, n, nums, dp, pre));
33            }
34        }
35        return dp[i][j] = max;
36    }
37}