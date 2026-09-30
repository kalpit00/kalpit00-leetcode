// Last updated: 9/29/2026, 9:06:28 PM
1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        char[] s = seq.toCharArray();
4        int count = 0, n = s.length;
5        int[] res = new int[n];
6        for (int i = 0; i < n; i++) {
7            count += s[i] == '(' ? 1 : 0;
8            res[i] = count % 2;
9            count += s[i] == ')' ? -1 : 0;
10        }
11        return res;
12    }
13}