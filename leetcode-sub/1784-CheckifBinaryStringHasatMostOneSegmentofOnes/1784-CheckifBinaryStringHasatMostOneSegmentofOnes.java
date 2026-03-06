// Last updated: 3/6/2026, 12:19:56 AM
1class Solution {
2    public boolean checkOnesSegment(String s) {
3        char[] a = s.toCharArray();
4        for (int i = 1; i < a.length; i++) {
5            if (a[i - 1] == '0' && a[i] == '1') {
6                return false;
7            }
8        }
9        return true;
10    }
11}