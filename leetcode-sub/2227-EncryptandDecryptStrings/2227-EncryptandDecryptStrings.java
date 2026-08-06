// Last updated: 8/6/2026, 12:54:05 AM
1class Solution {
2    int mod = 1000000007;
3    public int countStableSubsequences(int[] nums) {
4        int n = nums.length;
5        Long[][][] dp = new Long[n][3][3];
6        return (int) solve(0, n, 2, 2, nums, dp);
7    }
8    private long solve(int i, int n, int parity, int prev, int[] nums, 
9    Long[][][] dp) {
10        if (i == n) return 0;
11        if (dp[i][parity][prev] != null) return dp[i][parity][prev];
12        long take = 0;
13        long notTake = solve(i + 1, n, parity, prev, nums, dp);
14        if (prev == 2 || parity == 2 || (nums[i] % 2 != parity) || 
15        (nums[i] % 2 != prev)) {
16            take = 1 + solve(i + 1, n, nums[i] % 2, parity, nums, dp);
17            take %= mod;
18        }
19        return dp[i][parity][prev] = (take + notTake) % mod;
20    }
21}