// Last updated: 4/12/2025, 9:58:06 PM
class Solution {
    int mod = 1000000007;
    public int countGoodNumbers(long n) {
    // this is a combinatorics problem
    // there are 5 ways for every even index, and 4 ways for every odd index
    // so ans is simply (5 * 4 * 5 * 4....) = 5^(# even idxs) * 4^(# odd idxs)
        long even = (n + 1) / 2, odd = n / 2;
        long res = binExp(5L, even) % mod;
        res = res * binExp(4L, odd) % mod;
        return (int) (res);
    }
    private long binExp(long a, long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            n >>= 1;
        }
        return res;
    }
}