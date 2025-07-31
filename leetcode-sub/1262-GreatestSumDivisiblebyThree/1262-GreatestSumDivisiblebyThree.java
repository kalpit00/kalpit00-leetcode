// Last updated: 7/31/2025, 2:47:06 AM
class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][3];
        return solve(0, n, 0, nums, dp);
    }
    private int solve(int i, int n, int sum, int[] nums, Integer[][] dp) {
        if (i == n) {
            return sum == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        int notTake = solve(i + 1, n, sum, nums, dp);
        int take = nums[i] + solve(i + 1, n, (sum + nums[i]) % 3, nums, dp);
        return dp[i][sum] = Math.max(take, notTake);
    }
}