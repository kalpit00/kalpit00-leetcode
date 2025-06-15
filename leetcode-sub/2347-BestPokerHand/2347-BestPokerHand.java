// Last updated: 6/15/2025, 2:32:32 AM
class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int mod = 1000000007;
        int[][][] dp = new int[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 1; i <= Math.min(one, limit); i++) {
            dp[0][i][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % mod;
                if (i > limit){
                    dp[i][j][0] = (dp[i][j][0] + mod - dp[i - limit - 1][j][1]) % mod;
                }
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % mod;
                if (j > limit){
                    dp[i][j][1] = (dp[i][j][1] + mod - dp[i][j - limit - 1][0]) % mod;
                }
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }
}