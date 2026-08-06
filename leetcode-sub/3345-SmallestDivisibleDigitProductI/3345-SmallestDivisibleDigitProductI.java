// Last updated: 8/5/2026, 8:11:38 PM
1class Solution {
2    public int smallestNumber(int n, int t) {
3        int i = n;
4        while (true) {
5            int prod = 1;
6            int num = i;
7            while (num > 0) {
8                prod *= num % 10;
9                num /= 10;
10            }
11            if (prod % t == 0) {
12                return i;
13            }
14            i++;
15        }
16    }
17}