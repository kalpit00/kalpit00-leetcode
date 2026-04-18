// Last updated: 4/17/2026, 8:32:48 PM
1class Solution {
2    public int mirrorDistance(int n) {
3        return Math.abs(n - rev(n));
4    }
5    private int rev(int num) {
6        List<Integer> list = new ArrayList<>();
7        while (num > 0) {
8            list.add(num % 10);
9            num /= 10;
10        }
11        int n = list.size(), i = 0, res = 0;
12        while (i < n && list.get(i) == 0) {
13            i++;
14        }
15        while (i < n) {
16            res = res * 10 + list.get(i++);
17        }
18        return res;
19    }
20}