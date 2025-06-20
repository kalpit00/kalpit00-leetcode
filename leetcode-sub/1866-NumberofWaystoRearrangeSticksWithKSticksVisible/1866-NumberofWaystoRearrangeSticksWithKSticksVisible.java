// Last updated: 6/20/2025, 1:14:48 AM
class Solution {
    int mod = 1000000007;
    public int rearrangeSticks(int n, int k) {
        Long[][] dp = new Long[n + 1][k + 1];
        return (int) solve(n, k, dp);
    }
    private long solve(int n, int k, Long[][] dp) {
        if (k == 0 || k > n) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        if (dp[n][k] != null) {
            return dp[n][k];
        }
        long notTake = (solve(n - 1, k - 1, dp)) % mod;
        long take = ((n - 1) * solve(n - 1, k, dp)) % mod;
        return dp[n][k] = (take + notTake) % mod;
    }
}