// Last updated: 6/23/2025, 7:46:25 PM
class Solution {
    int mod = 1000000007;
    public int numberOfWays(int a, int b) {
        int n = (int) Math.round(Math.pow(a, 1.0 / b));
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = (int) Math.pow(i, b);
        }
        Integer[][] dp = new Integer[n + 1][a + 1];
        return solve(1, nums, 0, a, dp);
    }

    private int solve(int i, int[] nums, int sum, int target, Integer[][] dp) {
        if (sum == target) {
            return 1;
        }
        if (i >= nums.length || sum > target) {
            return 0;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        } 
        int notTake = solve(i + 1, nums, sum, target, dp);
        int take = 0;
        if (sum + nums[i] <= target) {
            take = solve(i + 1, nums, sum + nums[i], target, dp);
        }
        return dp[i][sum] = (take + notTake) % mod;
    }
}
