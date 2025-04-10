// Last updated: 4/9/2025, 9:01:47 PM
class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String b = String.valueOf(finish), a = String.valueOf(start - 1);
        int m = a.length(), n = b.length(), k = s.length();
        long x = 0, y = 0;        
        Long[][] dp1 = new Long[17][2], dp2 = new Long[17][2];
        if (k <= n) {
            x = solve(0, 1, b, s, limit, n, k, dp1);
        }
        if (k <= m) {
            y = solve(0, 1, a, s, limit, m, k, dp2);
        }
        return x - y;
    }

    private long solve(int idx, int tight, String num, String s, int limit, int m, int k, Long[][] dp) {
        if (idx == m) {
            return 1;
        }
        if (dp[idx][tight] != null) {
            return dp[idx][tight];
        }
        int lower = 0, upper = tight == 1 ? Math.min(limit, num.charAt(idx) - '0') : limit, sufIdx = m - k;
        if (sufIdx <= idx) {
            lower = s.charAt(idx - sufIdx) - '0';
            upper = Math.min(upper, s.charAt(idx - sufIdx) - '0');
        }
        long count = 0;
        for (int i = lower; i <= upper; i++) {
            int newTight = tight == 1 && i == num.charAt(idx) - '0' ? 1 : 0;
            count += solve(idx + 1, newTight, num, s, limit, m, k, dp);
        }
        return dp[idx][tight] = count;
    }
}
