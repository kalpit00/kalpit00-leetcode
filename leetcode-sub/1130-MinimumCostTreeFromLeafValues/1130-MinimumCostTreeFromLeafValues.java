// Last updated: 6/9/2025, 12:00:25 PM
class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        int mod = 1000000007;
        for (int i = n - 1; i >= 0; i--) {
            long mask = (long) 1 << i;
            if ((a & mask) != 0 && (b & mask) != 0) {
                continue;
            } 
            if ((a & mask) != 0) {
                if (a > b) {
                    a ^= mask;
                    b |= mask;
                }
                continue;
            }
            else if ((b & mask) != 0) {
                if (a < b) {
                    a |= mask;
                    b ^= mask;
                }
            }
            else {
                a |= mask;
                b |= mask;
            }
        }
        a %= mod;
        b %= mod;
        return (int) ((a * b) % mod);
    }

}