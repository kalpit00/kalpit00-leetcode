// Last updated: 1/7/2026, 7:43:04 PM
1class Solution {
2    public int maxDotProduct(int[] nums1, int[] nums2) {
3        int m = nums1.length, n = nums2.length, 
4        firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, 
5        firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
6        for (int num : nums1) {
7            firstMax = Math.max(firstMax, num);
8            firstMin = Math.min(firstMin, num);
9        }
10        for (int num : nums2) {
11            secondMax = Math.max(secondMax, num);
12            secondMin = Math.min(secondMin, num);
13        }
14
15        if ((firstMax < 0 && secondMin > 0) || (firstMin > 0 && secondMax < 0)){
16            return Math.max(firstMax * secondMin, firstMin * secondMax);
17        }
18        Integer[][] dp = new Integer[m][n];
19        return solve(nums1, nums2, m, n, 0, 0, dp);
20    }
21
22    private int solve(int[] nums1, int[] nums2, int m, int n, 
23    int i, int j, Integer[][] dp) {
24        if (i >= m || j >= n)
25            return 0;
26
27        if (dp[i][j] != null) {
28            return dp[i][j];
29        }
30        int take = nums1[i] * nums2[j] + solve(nums1, nums2, m, n,
31        i + 1, j + 1, dp);
32        int notTake1 = solve(nums1, nums2, m, n, i + 1, j, dp);
33        int notTake2 = solve(nums1, nums2, m, n, i, j + 1, dp);
34        return dp[i][j] = Math.max(take, Math.max(notTake1, notTake2));
35    }
36}