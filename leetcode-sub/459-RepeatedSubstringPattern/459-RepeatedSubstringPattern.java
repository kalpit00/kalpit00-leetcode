// Last updated: 3/26/2026, 11:01:37 PM
1class Solution {
2    public boolean repeatedSubstringPattern(String s) {
3        return (s + s).substring(1, 2*s.length() - 1).contains(s);
4    }
5}