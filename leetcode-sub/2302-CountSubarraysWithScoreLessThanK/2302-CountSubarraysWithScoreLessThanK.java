// Last updated: 6/12/2025, 5:43:51 PM
class Solution {
    public int lenLongestFibSubseq(int[] nums) {
        int n = nums.length, max = 0;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            int start = 0, end = i - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum > nums[i]) {
                    end--;
                }
                else if (sum < nums[i]) {
                    start++;
                }
                else {
                    dp[end][i] = Math.max(dp[end][i], dp[start][end] + 1);
                    max = Math.max(max, dp[end][i]);
                    start++;
                    end--;
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
}