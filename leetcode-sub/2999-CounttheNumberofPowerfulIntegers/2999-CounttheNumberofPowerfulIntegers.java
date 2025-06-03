// Last updated: 6/3/2025, 1:54:13 AM
class Solution {
    public long numberOfPowerfulInt(long start, long finish, int threshold, String s) {
        for (char c : s.toCharArray()) {
            if (c - '0' > threshold) {
                return 0;
            }
        }
        String b = String.valueOf(finish), a = String.valueOf(start - 1);
        int m = a.length(), n = b.length(), k = s.length();
        Long[][] dp1 = new Long[17][2], dp2 = new Long[17][2];
        long res2 = k <= n ? solve(0, 1, b, s, threshold, n, k, dp1) : 0;
        long res1 = k <= m ? solve(0, 1, a, s, threshold, m, k, dp2) : 0;
        return res2 - res1;
    }

    private long solve(int idx, int tight, String num, String s, int threshold, int m, int k, Long[][] dp) {
        if (idx == m) {
            return 1;
        }
        if (dp[idx][tight] != null) {
            return dp[idx][tight];
        }
        long count = 0;
        if (idx >= m - k) {
            int digit = s.charAt(idx - (m - k)) - '0';
            if (digit <= threshold) {
                int limit = tight == 1 ? num.charAt(idx) - '0' : threshold;
                if (digit <= limit) {
                    int newTight = (tight == 1 && 
                    digit == num.charAt(idx) - '0') ? 1 : 0;
                    count += solve(idx + 1, newTight, num, s, threshold, 
                    m, k, dp);
                }
            }
        } 
        else {
            int limit = tight == 1 ? Math.min(threshold, num.charAt(idx) - '0')
            : threshold;
            for (int i = 0; i <= limit; i++) {
                int newTight = (tight == 1 && i == num.charAt(idx) - '0') 
                ? 1 : 0;
                count += solve(idx + 1, newTight, num, s, threshold, m, k, dp);
            }
        }
        return dp[idx][tight] = count;
    }
}
