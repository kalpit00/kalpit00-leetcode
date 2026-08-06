// Last updated: 8/6/2026, 7:51:40 PM
1class Solution {
2    public long countBalanced(long low, long high) {
3        String a = String.valueOf(low - 1), b = String.valueOf(high);
4        int m = a.length(), n = b.length();
5        Long[][][][][] dp = new Long[n][2][n * 5][n * 5][2];
6        long right = solve(b, n, 0, 1, 0, 0, 0, dp);
7        for (int i = 0; i < n; i++) {
8            for (int tight = 0; tight < 2; tight++) {
9                for (int odd = 0; odd < n * 5; odd++) {
10                    for (int even = 0; even < n * 5; even++) {
11                        Arrays.fill(dp[i][tight][odd][even], null);
12                    }
13                }
14            }
15        }
16        long left = solve(a, m, 0, 1, 0, 0, 0, dp);
17        return right - left;
18    }
19
20    private long solve(String num, int m, int idx, int tight, int odd, int even, int parity, Long[][][][][] dp) {
21        if (idx == m) {
22            return odd == even ? 1 : 0;
23        }
24        if (dp[idx][tight][odd][even][parity] != null) {
25            return dp[idx][tight][odd][even][parity];
26        }
27        int limit = tight == 1 ? num.charAt(idx) - '0' : 9;
28        long count = 0;
29        for (int i = 0; i <= limit; i++) {
30            int newTight = tight == 1 && i == limit ? 1 : 0;
31            int newOdd = parity == 0 ? odd + i : odd;
32            int newEven = parity == 0 ? even : even + i;
33            int newParity = (parity + 1) % 2;
34            count += solve(num, m, idx + 1, newTight, newOdd, newEven, newParity, dp);
35        }
36        return dp[idx][tight][odd][even][parity] = count;
37    }
38}