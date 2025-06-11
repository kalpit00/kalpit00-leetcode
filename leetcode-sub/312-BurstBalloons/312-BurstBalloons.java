// Last updated: 6/10/2025, 8:59:09 PM
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        balloons[0] = balloons[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return burst(balloons, dp, 0, n + 1);
    }

    private int burst(int[] balloons, int[][] dp, int left, int right) {
        if (left + 1 == right) return 0;
        if (dp[left][right] != -1) return dp[left][right];

        int max = 0;
        for (int i = left + 1; i < right; i++) {
            int coins = balloons[left] * balloons[i] * balloons[right]
                      + burst(balloons, dp, left, i)
                      + burst(balloons, dp, i, right);
            max = Math.max(max, coins);
        }

        dp[left][right] = max;
        return max;
    }
}
