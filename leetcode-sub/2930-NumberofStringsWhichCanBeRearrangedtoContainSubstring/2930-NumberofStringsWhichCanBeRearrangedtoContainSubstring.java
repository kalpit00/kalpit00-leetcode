// Last updated: 8/30/2025, 5:51:08 PM
class Solution {
    int mod = 1000000007;
    public int stringCount(int n) {
        if (n < 4) {
            return 0;
        }
        Long[][][][] dp = new Long[n][3][2][2];
        return (int) solve(0, n, 0, 0, 0, dp);
    }
    private long solve(int i, int n, int e, int l, int t, Long[][][][] dp) {
        if (i == n) {
            return e >= 2 && t >= 1 && l >= 1 ? 1 : 0;
        }
        if (dp[i][e][l][t] != null) {
            return dp[i][e][l][t];
        }
        long ans = 0;
        for (int j = 0; j < 26; j++) {
            char c = (char) (j + 'a'); // [0, 25] -> [a, z]
            if (c == 'e' && e < 2) {
                ans = ans + (solve(i + 1, n, e + 1, l, t, dp) % mod);
            }
            else if (c == 'l' && l < 1) {
                ans = ans + (solve(i + 1, n, e, l + 1, t, dp) % mod);
            }
            else if (c == 't' && t < 1) {
                ans = ans + (solve(i + 1, n, e, l, t + 1, dp) % mod);
            }
            else { // any char other than [e, l, t]
                ans = ans + (solve(i + 1, n, e, l, t, dp) % mod);
            }
        }
        return dp[i][e][l][t] = ans % mod;
    }
}