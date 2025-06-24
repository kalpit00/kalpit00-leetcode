// Last updated: 6/24/2025, 4:07:13 PM
class Solution {
    public int numSquares(int num) {
        int n = (int) Math.sqrt(num);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (i + 1) * (i + 1);
        }
        Integer[][] dp = new Integer[n][num + 1];
        return solve(0, nums, 0, num, dp);
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
        if (sum + nums[i] <= target) {
            int res = solve(i, nums, sum + nums[i], target, dp);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }
        return dp[i][sum] = Math.min(take, notTake);
    }
}