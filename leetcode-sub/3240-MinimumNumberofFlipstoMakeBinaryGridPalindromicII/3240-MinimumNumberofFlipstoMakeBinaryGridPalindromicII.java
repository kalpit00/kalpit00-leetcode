// Last updated: 2/14/2026, 5:44:37 PM
1class Solution {
2    public long removeZeros(long n) {
3        List<Long> list = new ArrayList<>();
4        while (n > 0) {
5            long d = n % 10;
6            if (d != 0) {
7                list.add(d);
8            }
9            n /= 10;
10        }
11        long res = 0;
12        for (int i = list.size() - 1; i >= 0; i--) {
13            res = res * 10 + list.get(i);
14        }
15        return res;
16    }
17}