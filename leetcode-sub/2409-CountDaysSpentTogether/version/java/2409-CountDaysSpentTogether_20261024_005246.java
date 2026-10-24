// Last updated: 10/24/2026, 12:52:46 AM
1class Solution {
2    public int countDaysTogether(String a, String b, String c, String d) {
3        return Math.max(0, Math.min(f(b), f(d)) - Math.max(f(a), f(c)) + 1);
4    }
5
6    int f(String s) {
7        var m = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
8        var q = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
9
10        return (275 * m) / 9 - 30 - 2 * ((m + 9) / 12) + q;
11    }
12}