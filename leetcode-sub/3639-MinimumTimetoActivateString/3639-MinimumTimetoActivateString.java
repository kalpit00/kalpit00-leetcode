// Last updated: 2/15/2026, 2:47:03 PM
1class Solution {
2    public int minTime(String s, int[] order, int k) {
3        int n = s.length(), m = order.length;
4        TreeSet<Integer> set = new TreeSet<>();
5        set.add(-1);
6        set.add(n);
7        for (int i = 0; i < m; i++) {
8            Integer r = set.ceiling(order[i]);
9            Integer l = set.floor(order[i]);
10            k -= (long) (order[i] - l) * (r - order[i]);
11            set.add(order[i]);
12            if (k <= 0) {
13                return i;
14            }
15        }
16        return -1;
17    }
18}