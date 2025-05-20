// Last updated: 5/20/2025, 6:50:22 PM
import java.math.BigInteger;
class Solution {
    int mod = 1000000007;
    public int countSteppingNumbers(String low, String high) {
        String a = new BigInteger(low).subtract(BigInteger.ONE).toString();
        String b = high;
        int m = a.equals("0") ? 0 : a.length(), n = b.length();
        Long[][][] dp2 = new Long[n][2][11];
        long res2 = solve(b, n, 0, 1, -1, dp2);
        if (m == 0) {
            return (int) res2 % mod;
        }
        Long[][][] dp1 = new Long[m][2][11];
        long res1 = solve(a, m, 0, 1, -1, dp1);
        return (int) ((res2 - res1 + mod) % mod);
    }
        private long solve(String num, int m, int idx, int tight, int prev,
        Long[][][] dp) {
        if (idx == m) {
            return prev != -1 ? 1 : 0;
        }
        if (dp[idx][tight][prev + 1] != null) {
            return dp[idx][tight][prev + 1];
        }
        int limit = tight == 1 ? num.charAt(idx) - '0' : 9;
        long count = 0;
        for (int i = 0; i <= limit; i++) {
            int newTight = tight == 1 && i == limit ? 1 : 0;
            if (prev == -1 && i == 0) { // skip leading zeros
                count = (count + solve(num, m, idx + 1, newTight, prev,
                dp)) % mod;
            } // dfs, passing 'i' instead of prev
            else if (prev == -1 || Math.abs(i - prev) == 1) {
                count = (count + solve(num, m, idx + 1, newTight, i,
                dp)) % mod;
            }
        }
        return dp[idx][tight][prev + 1] = count % mod;
    }
}