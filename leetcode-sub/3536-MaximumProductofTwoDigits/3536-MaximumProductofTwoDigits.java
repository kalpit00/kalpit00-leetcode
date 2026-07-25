// Last updated: 7/24/2026, 8:53:39 PM
1class Solution {
2    public int maxProduct(int n) {
3        int max = 0, secondMax = 0;
4        while (n > 0) {
5            int d = n % 10;
6            if (d > max) {
7                secondMax = max;
8                max = d;
9            }
10            else if (d > secondMax) {
11                secondMax = d;
12            }
13            n /= 10;
14        }
15        return max * secondMax;
16    }
17}