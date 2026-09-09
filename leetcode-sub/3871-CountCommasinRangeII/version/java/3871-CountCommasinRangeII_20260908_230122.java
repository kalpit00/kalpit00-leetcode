// Last updated: 9/8/2026, 11:01:22 PM
1class Solution {
2    public long countCommas(long n) {
3        long p = 1000, res = 0;
4        while (p <= n) {
5            res += n - p + 1;
6            p *= 1000;
7        }
8        return res;
9    }
10}