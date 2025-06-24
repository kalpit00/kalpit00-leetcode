// Last updated: 6/24/2025, 4:12:02 PM
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        int res = solve(0, coins, 0, amount, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private int solve(int i, int[] nums, int sum, int target, Integer[][] dp) {
        if (sum == target) {
            return 0;
        }
        if (i >= nums.length || sum > target) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        int notTake = solve(i + 1, nums, sum, target, dp);
        int take = Integer.MAX_VALUE;
        if (nums[i] <= target - sum) {
            int res = solve(i, nums, sum + nums[i], target, dp);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }
        return dp[i][sum] = Math.min(take, notTake);
    }
}