// Last updated: 8/6/2026, 12:54:58 AM
1class Solution {
2    int mod = 1000000007;
3    public int countStableSubsequences(int[] nums) {
4        int n = nums.length;
5        Long[][][] dp = new Long[n][3][3];
6        return (int) solve(0, n, 2, 2, nums, dp);
7    }
8    private long solve(int i, int n, int prev, int prev2, int[] nums, 
9    Long[][][] dp) {
10        if (i == n) return 0;
11        if (dp[i][prev][prev2] != null) return dp[i][prev][prev2];
12        long take = 0;
13        long notTake = solve(i + 1, n, prev, prev2, nums, dp);
14        if (prev2 == 2 || prev == 2 || (nums[i] % 2 != prev) || 
15        (nums[i] % 2 != prev2)) {
16            take = 1 + solve(i + 1, n, nums[i] % 2, prev, nums, dp);
17            take %= mod;
18        }
19        return dp[i][prev][prev2] = (take + notTake) % mod;
20    }
21}