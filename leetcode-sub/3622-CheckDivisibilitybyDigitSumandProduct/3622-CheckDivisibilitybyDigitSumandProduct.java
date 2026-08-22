// Last updated: 8/22/2026, 1:23:56 AM
1class Solution {
2    public boolean checkDivisibility(int n) {
3        int sum = 0, prod = 1, num = n;
4        while (num > 0) {
5            int d = num % 10;
6            sum += d;
7            prod *= d;
8            num /= 10;
9        }
10        return n % (sum + prod) == 0;
11    }
12}