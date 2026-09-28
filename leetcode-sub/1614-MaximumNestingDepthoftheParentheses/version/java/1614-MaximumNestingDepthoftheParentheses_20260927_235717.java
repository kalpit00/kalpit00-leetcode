// Last updated: 9/27/2026, 11:57:17 PM
1class Solution {
2    public int maxDepth(String s) {
3        int max = 0, count = 0;
4        for (char c : s.toCharArray()) {
5            count += c == '(' ? 1 : c == ')' ? -1 : 0;
6            max = Math.max(max, count);
7        }
8        return max;
9    }
10}