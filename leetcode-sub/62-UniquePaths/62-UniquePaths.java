// Last updated: 5/20/2026, 6:41:45 AM
1import java.math.BigInteger;
2class Solution {
3    public int uniquePaths(int m, int n) {
4        return nCr(m + n - 2, m - 1).intValue();
5    }
6    private BigInteger nCr(int n, int r) {
7        r = Math.min(r, n - r);
8        BigInteger res = BigInteger.ONE;
9        for (int i = 1; i <= r; i++) {
10            res = res.multiply(BigInteger.valueOf(n - r + i));
11            res = res.divide(BigInteger.valueOf(i));
12        }
13        return res;
14    }
15}