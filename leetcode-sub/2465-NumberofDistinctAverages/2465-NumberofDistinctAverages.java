// Last updated: 6/6/2025, 3:06:51 PM
class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long start = 1, end = (long) 1e11, ans = -1;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (helper(coins, mid, k)) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
    private boolean helper(int[] coins, long mid, int k) {
        int m = coins.length;
        long count = 0;
        for (int mask = 1; mask < (1 << m); mask++) {
            long lcm = 1;
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                }
            }
            count += (Integer.bitCount(mask) & 1) == 1 ? mid / lcm : -mid / lcm;
        }
        return count >= k;
    }
    private long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }
    private long lcm(long x, long y) {
        return Math.abs(x * y) / gcd(x, y);
    }
}