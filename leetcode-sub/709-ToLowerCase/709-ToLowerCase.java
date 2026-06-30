// Last updated: 6/30/2026, 8:05:57 AM
1class Solution {
2    public String toLowerCase(String s) {
3        char[] c = s.toCharArray();
4        for (int i = 0; i < c.length; i++) {
5            c[i] = c[i] < 'A' || c[i] > 'Z' ? c[i] : (char) ((c[i] - 'A') + 'a');
6        }
7        return new String(c);
8    }
9}