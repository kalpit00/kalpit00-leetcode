// Last updated: 8/13/2026, 8:06:28 PM
1class Solution {
2
3    public int maximumLengthSubstring(String s) {
4        int n = s.length();
5        int res = 0;
6        for (int left = 0; left < n; left++) {
7            int[] count = new int[26];
8            for (int right = left; right < n; right++) {
9                int ch = s.charAt(right) - 'a';
10                count[ch]++;
11                if (count[ch] > 2) {
12                    break;
13                }
14                res = Math.max(res, right - left + 1);
15            }
16        }
17        return res;
18    }
19}