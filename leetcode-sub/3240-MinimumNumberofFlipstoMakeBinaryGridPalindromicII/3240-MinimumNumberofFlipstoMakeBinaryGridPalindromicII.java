// Last updated: 2/14/2026, 5:48:29 PM
1class Solution {
2    public long removeZeros(long n) {
3        long res = 0, pow = 1;
4        while (n > 0) {
5            long d = n % 10;
6            if (d != 0) {
7                res = d * pow + res;
8                pow *= 10;
9            }
10            n /= 10;
11        }
12        return res;
13    }
14}