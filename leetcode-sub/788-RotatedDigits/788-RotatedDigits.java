// Last updated: 5/1/2026, 9:54:58 PM
1class Solution {
2    public int rotatedDigits(int n) {
3        int res = 0;
4        outer:
5        for (int i = 1; i <= n; i++) {
6            int num = i, count = 0;
7            while (num > 0) {
8                int d = num % 10;
9                if (d == 3 || d == 4 || d == 7) {
10                    continue outer;
11                }
12                count += d == 2 || d == 5 || d == 6 || d == 9 ? 1 : 0;
13                num /= 10;
14            }
15            res += count > 0 ? 1 : 0;
16        }
17        return res;
18    }
19}