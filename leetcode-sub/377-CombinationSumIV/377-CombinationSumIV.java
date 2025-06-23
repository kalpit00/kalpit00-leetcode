// Last updated: 6/23/2025, 1:28:02 PM
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][target];
        return solve(0, n, nums, 0, target, dp);
    }
    private int solve(int i, int n, int[] nums, int sum, 
    int target, Integer[][] dp) {       
        if (i >= n || sum > target) {
            return 0;
        }
        if (sum == target) {
            return 1;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        int notTake = solve(i + 1, n, nums, sum, target, dp);
        int take = solve(0, n, nums, sum + nums[i], target, dp);
        return dp[i][sum] = take + notTake;
    }
}