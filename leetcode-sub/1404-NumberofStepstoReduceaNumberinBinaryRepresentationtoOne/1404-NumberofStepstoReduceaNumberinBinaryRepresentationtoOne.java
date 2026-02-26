// Last updated: 2/25/2026, 8:58:52 PM
1class Solution {
2    public int numSteps(String s) {
3// count 1's and number of 0's between leftmost and rightmost occurrences of 1
4        int ones = 0, zeroes = 1, n = s.length();
5        for (int i = n - 1; i >= 0; i--) {
6            ones+= s.charAt(i) == '1' ? 1 : 0;
7            zeroes+= ones > 0 && s.charAt(i) == '0' ? 1 : 0;
8        }
9        return ones == 1 ? n - 1 : zeroes + n;
10    }
11}