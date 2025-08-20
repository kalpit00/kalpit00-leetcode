// Last updated: 8/20/2025, 3:09:48 PM
class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][1 << n];
        return solve(1, n, 0, nums, dp);
    }
    private int solve(int i, int n, int mask, int[] nums, Integer[][] dp) {
        if (i > n / 2) {
            return 0;
        }
        if (dp[i][mask] != null) {
            return dp[i][mask];
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int newMask = (1 << j) | (1 << k);
                if ((mask & newMask) != 0) continue;
                max = Math.max(max, i * gcd(nums[j], nums[k]) + 
                solve(i + 1, n, mask | newMask, nums, dp));
            }
        }
        return dp[i][mask] = max;
    }
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}