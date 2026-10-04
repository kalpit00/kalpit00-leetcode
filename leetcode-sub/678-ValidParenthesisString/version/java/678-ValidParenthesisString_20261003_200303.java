// Last updated: 10/3/2026, 8:03:03 PM
1class Solution {
2    public boolean checkValidString(String s) {
3        int n = s.length(), left = 0, right = 0;
4        for (int i = 0; i < n; i++) {
5            char x = s.charAt(i), y = s.charAt(n - i - 1);
6            left += (x == '(' || x == '*') ? 1 : -1;
7            right += (y == ')' || y == '*') ? 1 : -1;
8            if (left < 0 || right < 0) {
9                return false;
10            } // unbalanced parenthesis
11        }
12        return true;
13    }
14}