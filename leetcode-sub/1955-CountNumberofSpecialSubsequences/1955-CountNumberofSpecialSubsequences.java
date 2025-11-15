// Last updated: 11/14/2025, 9:45:22 PM
class Solution {
    public int countSpecialSubsequences(int[] nums) {
        int mod = 1000000007;
        long[] dp = new long[3];
        for (int i : nums) {
            if (i == 0) {
                dp[i] += dp[i] + 1;
            }
            else {
                dp[i] += dp[i] + dp[i - 1];
            }
            dp[i] %= mod;
        }
        return (int) dp[2];
    }
}