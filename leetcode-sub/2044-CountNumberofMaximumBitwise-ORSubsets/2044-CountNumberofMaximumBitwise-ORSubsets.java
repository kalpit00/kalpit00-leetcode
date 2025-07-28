// Last updated: 7/27/2025, 8:27:59 PM
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length, max = 0;
        for (int num : nums) {
            max |= num;
        }
        Integer[][] dp = new Integer[n][1 << 17];
        return solve(0, n, nums, 0, max, dp);
    }
    private int solve(int i, int n, int[] nums, int xOr, int max, 
    Integer[][] dp) {
        if (i >= n) {
            return xOr == max ? 1 : 0;
        }
        if (dp[i][xOr] != null) {
            return dp[i][xOr];
        }
        int take = solve(i + 1, n, nums, xOr | nums[i], max, dp);
        int notTake = solve(i + 1, n, nums, xOr, max, dp);
        return dp[i][xOr] = take + notTake;
    }
}