// Last updated: 7/16/2025, 8:51:49 PM
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length, max = 0;
        int[][] dp = new int[n][k];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int sum = (nums[j] + nums[i]) % k;
                dp[i][sum] = Math.max(dp[i][sum], dp[j][sum] + 1);
                max = Math.max(max, dp[i][sum]);
            }
        }
        return max + 1;
    }
}