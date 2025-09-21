// Last updated: 9/21/2025, 5:07:45 PM
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
            long res = 1L;
            for (int j = 0; j < n - count; j++) {
                res = (res * 2) % mod;
            }
            return (int) res;
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
}