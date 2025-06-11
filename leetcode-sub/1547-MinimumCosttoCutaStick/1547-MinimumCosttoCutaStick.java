// Last updated: 6/11/2025, 2:05:30 AM
class Solution {
    public int minCost(int n, int[] cuts) {
        int[] nums = new int[cuts.length + 2];
        int m = nums.length;
        for (int i = 0; i < cuts.length; i++) {
            nums[i] = cuts[i];
        }
        nums[m - 1] = n;
        Arrays.sort(nums);
        Integer[][] dp = new Integer[m + 1][m + 1];
        return solve(0, m - 1, nums, dp);
    }
    private int solve(int i, int j, int[] nums, Integer[][] dp) {
        if (j - i <= 1) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            min = Math.min(min, nums[j] - nums[i] + 
            solve(i, k, nums, dp) + solve(k, j, nums, dp));
        }
        return dp[i][j] = min;
    }
}