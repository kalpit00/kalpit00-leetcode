// Last updated: 3/28/2026, 10:24:08 PM
1class Solution {
2    public boolean canBeEqual(String s1, String s2) {
3        char[] a = s1.toCharArray(), b = s2.toCharArray();
4        return ((a[0] == b[0] && a[2] == b[2]) || (a[0] == b[2] && a[2] == b     [0])) && ((a[1] == b[1] && a[3] == b[3]) || (a[1] == b[3] && a[3] == b[1]));
5    }
6}