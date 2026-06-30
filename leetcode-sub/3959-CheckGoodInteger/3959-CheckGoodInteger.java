// Last updated: 6/30/2026, 1:24:25 AM
1class Solution {
2    public boolean checkGoodInteger(int n) {
3        int sum = 0, sq = 0;
4        while (n > 0) {
5            int d = n % 10;
6            sum += d;
7            sq += d * d;
8            n /= 10;
9        }
10        return sq - sum >= 50;
11    }
12}