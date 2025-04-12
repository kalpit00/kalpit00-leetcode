// Last updated: 4/12/2025, 3:16:43 AM
class Solution {
    int mod = 1000000007;
    public int sumOfPower(int[] nums, int k) {
        int n = nums.length;
        Integer[][][] dp = new Integer[n + 1][n + 1][k + 1];
        return solve(nums, 0, n, k, 0, 0, dp);
    }
    private int solve(int[] nums, int i, int n, int k, int sum, int count, 
    Integer[][][] dp) {
        if (i == n) {
            return sum == k ? helper(n - count) : 0;
        }
        if (dp[i][count][sum] != null) {
            return dp[i][count][sum];
        }
        int notTake = solve(nums, i + 1, n, k, sum, count, dp);
        int take = 0;
        if (sum + nums[i] <= k) {
            take += solve(nums, i + 1, n, k, sum + nums[i], count + 1, dp);
        }
        return dp[i][count][sum] = (take + notTake) % mod;
    }
    private int helper(int exp) {
        long result = 1;
        long b = 2;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }   
        return (int) result;
    }
}