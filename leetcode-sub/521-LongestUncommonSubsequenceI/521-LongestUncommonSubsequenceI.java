// Last updated: 2/22/2026, 1:38:17 PM
1class Solution {
2    public int findLUSlength(String a, String b) {
3        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
4    }
5}