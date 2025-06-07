// Last updated: 6/6/2025, 11:56:08 PM
import java.math.BigInteger;
class Solution {
    int mod = 1000000007;
    public int idealArrays(int n, int maxValue) {
        BigInteger res = BigInteger.ZERO;
        long[][] dp = new long[15][maxValue + 1]; 
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= maxValue; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 1; i <= maxValue; i++) {
            for (int j = i * 2; j <= maxValue; j += i) {
                map.get(j).add(i);
            }
        }
        for (int i = 1; i <= maxValue; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n && i <= 14; i++) {
            for (int j = 1; j <= maxValue; j++) {
                for (int k : map.get(j)) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= mod;
                }
            }
        }
        for (int i = 1; i <= n && i <= 14; i++) {
            for (int j = 1; j <= maxValue; j++) {
                dp[i][0] += dp[i][j];
                dp[i][0] %= mod;
            }
        }        
        for (int i = 1; i <= n && i <= 14; i++) {
            res = res.add(nCk(n - 1, i - 1).multiply(BigInteger.valueOf(dp[i][0])));
            res = res.mod(BigInteger.valueOf(mod));
        }
        return res.intValue();
    }
    
    private BigInteger nCk(int n, int k) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            res = res.multiply(BigInteger.valueOf(n - (i - 1))).divide(BigInteger.valueOf(i));
        }
        return res;
    }
}