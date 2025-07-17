// Last updated: 7/16/2025, 9:16:48 PM
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, max = 1, k = 500;
        int[][] dp = new int[n][2 * k + 1];
        for (int[] r : dp) {
            Arrays.fill(r, 1);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + k;
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                max = Math.max(max, dp[i][d]);
            }
        }
        return max;
    }
}