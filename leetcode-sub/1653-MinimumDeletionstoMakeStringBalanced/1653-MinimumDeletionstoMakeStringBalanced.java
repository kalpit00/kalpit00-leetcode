// Last updated: 2/6/2026, 8:43:58 PM
1class Solution {
2    public int minimumDeletions(String s) {
3        int min = 0, count = 0;
4        for (char c : s.toCharArray()) {
5            if (c == 'b') {
6                count++;
7            }
8            else {
9                min = Math.min(min + 1, count);
10            }
11        }
12        return min;
13    }
14}