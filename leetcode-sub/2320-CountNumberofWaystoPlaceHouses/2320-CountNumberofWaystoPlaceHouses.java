// Last updated: 5/16/2025, 11:56:39 PM
class Solution {
    int mod = 1000000007;
    public int countHousePlacements(int n) {
        Long[] dp = new Long[n];
        long res = (1 + solve(0, n, dp)) % mod;
        return (int) (res % mod * res % mod) % mod;
    }
    private long solve(int i, int n, Long[] dp) {
        if (i == n - 1) {
            return 1;
        }
        if (i >= n) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        long notTake = (solve(i + 1, n, dp)) % mod;
        long take = (1 + solve(i + 2, n, dp)) % mod;
        return dp[i] = (take + notTake) % mod;
    }
}