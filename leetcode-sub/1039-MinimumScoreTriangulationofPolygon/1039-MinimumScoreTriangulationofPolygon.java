// Last updated: 9/28/2025, 9:20:43 PM
class Solution {
    public int minScoreTriangulation(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        return solve(1, n - 1, n, nums, dp);   
    }
	private int solve(int i, int j, int n, int[] nums, Integer[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, nums[i - 1] * nums[k] * nums[j] + 
            solve(i, k, n, nums, dp) + solve(k + 1, j, n, nums, dp));
        }
        return dp[i][j] = min;
    }
}