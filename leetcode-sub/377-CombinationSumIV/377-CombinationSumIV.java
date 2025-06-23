// Last updated: 6/23/2025, 7:47:41 PM
class Solution {
    int mod = 1000000007;
    public int numberOfWays(int a, int b) {
        int n = (int) Math.round(Math.pow(a, 1.0 / b));
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) Math.pow(i + 1, b);
        }
        Integer[][] dp = new Integer[n][a];
        return solve(0, nums, 0, a, dp);
    }

    private int solve(int i, int[] nums, int sum, int target, Integer[][] dp) {
        if (sum == target) {
            return 1;
        }
        if (i >= nums.length || sum >= target) {
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
