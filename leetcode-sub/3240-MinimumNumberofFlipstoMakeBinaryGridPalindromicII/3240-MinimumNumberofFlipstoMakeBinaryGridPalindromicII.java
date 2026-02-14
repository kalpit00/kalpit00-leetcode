// Last updated: 2/14/2026, 5:46:40 PM
1class Solution {
2    public long removeZeros(long n) {
3        long res = 0;
4        int i = 0;
5        while (n > 0) {
6            long d = n % 10;
7            if (d != 0) {
8                res = d * (long) Math.pow(10, i++) + res;
9            }
10            n /= 10;
11        }
12        return res;
13    }
14}