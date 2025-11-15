// Last updated: 11/14/2025, 9:46:13 PM
class Solution {
    public int countSpecialSubsequences(int[] nums) {
        int mod = 1000000007;
        long[] dp = new long[3];
        for (int i : nums) {
            dp[i] += dp[i] + (i == 0 ? 1 : dp[i - 1]);
            dp[i] %= mod;
        }
        return (int) dp[2];
    }
}