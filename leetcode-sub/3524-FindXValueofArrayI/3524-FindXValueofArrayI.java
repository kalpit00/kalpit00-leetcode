// Last updated: 7/17/2025, 1:56:44 PM
class Solution {
    public int minimumIncrements(int[] nums, int[] target) {
        int m = target.length;
        long[] map = new long[1 << m], prev = new long[1 << m];
        Arrays.fill(prev, Long.MAX_VALUE / 2);
        prev[0] = 0;
        for (int mask = 1; mask < (1 << m); mask++) {
            long lcm = 1;
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, target[i]);
                }
            }
            map[mask] = lcm;
        }
        for (int num : nums) {
            long[] curr = prev.clone();
            for (int mask = 1; mask < (1 << m); mask++) {
                long lcm = map[mask], rem = num % lcm;
                long cost = rem == 0 ? 0 : lcm - rem;
                for (int oldMask = 0; oldMask < (1 << m); oldMask++) {
                    int newMask = oldMask | mask;
                    curr[newMask] = Math.min(curr[newMask], 
                    prev[oldMask] + cost);
                }
            }
            prev = curr;
        }
        return (int) prev[(1 << m) - 1];
    }

    private long gcd(long x, long y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    private long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }
}
