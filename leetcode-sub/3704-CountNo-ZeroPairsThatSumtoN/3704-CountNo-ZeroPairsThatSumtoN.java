// Last updated: 1/15/2026, 11:42:08 AM
1class Solution {
2    public long countNoZeroPairs(long n) {
3        String num = new StringBuilder(String.valueOf(n)).reverse().toString();
4        int m = num.length();
5        Long[][][][] dp = new Long[m][2][2][2];
6        return solve(num, m, 0, 0, 0, 0, dp);
7    }
8    private long solve(String num, int m, int idx, int carry, 
9        int hasZeroA, int hasZeroB, Long[][][][] dp) {
10        if (idx == m) {
11            return carry == 0 ? 1 : 0;
12        }
13        if (dp[idx][carry][hasZeroA][hasZeroB] != null) {
14            return dp[idx][carry][hasZeroA][hasZeroB];
15        }
16        int limitA = hasZeroA == 1 ? 0 : 9;
17        int limitB = hasZeroB == 1 ? 0 : 9;
18        int startA = (idx == 0) ? 1 : 0;
19        int startB = (idx == 0) ? 1 : 0;
20        long count = 0;
21        for (int i = startA; i <= limitA; i++) {
22            for (int j = startB; j <= limitB; j++) {
23                int sum = i + j + carry;
24                if (sum % 10 == num.charAt(idx) - '0') {
25                    int newCarry = sum / 10;
26                    int newHasZeroA = hasZeroA | (i == 0 ? 1 : 0);
27                    int newHasZeroB = hasZeroB | (j == 0 ? 1 : 0);
28                    count += solve(num, m, idx + 1, newCarry, 
29                    newHasZeroA, newHasZeroB, dp);
30                }
31            }
32        }
33        return dp[idx][carry][hasZeroA][hasZeroB] = count;
34    }
35}