// Last updated: 2/22/2026, 3:31:07 AM
1class Solution {
2    public int binaryGap(int n) {
3        char[] s = Integer.toBinaryString(n).toCharArray();
4        int max = 0, m = s.length, prev = 0;
5        for (int i = 0; i < m; i++) {
6            if (s[i] == '1') {
7                max = Math.max(max, i - prev);
8                prev = i;
9            }
10        }
11        return max;
12    }
13}