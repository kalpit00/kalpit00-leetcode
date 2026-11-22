// Last updated: 11/21/2026, 7:16:22 PM
1class Solution {
2    public boolean checkString(String s) {
3        for (int i = 1; i < s.length(); i++) {
4            if (s.charAt(i) == 'a' && s.charAt(i-1) == 'b') {
5                return false;
6            }
7        }
8        return true;
9    }
10}