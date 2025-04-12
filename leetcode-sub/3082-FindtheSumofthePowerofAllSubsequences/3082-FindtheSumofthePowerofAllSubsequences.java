// Last updated: 4/12/2025, 3:35:24 AM
class Solution {
    int mod = 1000000007;
    public int sumOfPower(int[] nums, int k) {
        int n = nums.length;
        Integer[][][] dp = new Integer[n + 1][n + 1][k + 1];
        return solve(nums, 0, n, k, 0, 0, dp);
    }
    private int solve(int[] nums, int i, int n, int k, int sum, int count, 
    Integer[][][] dp) {
        if (sum == k) {
            return helper(n - count); // ftn to calc 2^(x) with mod!
        }
        if (i >= n || sum > k) {
            return 0;
        }
        if (dp[i][count][sum] != null) {
            return dp[i][count][sum];
        }
        int take = solve(nums, i + 1, n, k, sum + nums[i], count + 1, dp);
        int notTake = solve(nums, i + 1, n, k, sum, count, dp);
        return dp[i][count][sum] = (take + notTake) % mod;
    }
    private int helper(int n) {
        long res = 1L;
        for (int i = 0; i < n; i++) {
           res = (res * 2) % mod;
        }
        return (int) res;
        // long a = 2;
        // while (n > 0) {
        //     if (n % 2 == 1) {
        //         res = (res * a) % mod;
        //     }
        //     a = (a * a) % mod;
        //     n /= 2;
        // }
    }
}