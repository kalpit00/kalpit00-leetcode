// Last updated: 8/19/2025, 4:58:03 AM
class Solution {
    public int maxTotalReward(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Integer[][] dp = new Integer[n][4000];
        return solve(0, n, 0, nums, dp);
    }
    private int solve(int i, int n, int sum, int[] nums, Integer[][] dp) {
        if (i >= n) {
            return 0;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        int notTake = solve(i + 1, n, sum, nums, dp);
        int take = nums[i] > sum ? nums[i] + 
        solve(i + 1, n, sum + nums[i], nums, dp) : 0;
        return dp[i][sum] = Math.max(take, notTake);
    }
}