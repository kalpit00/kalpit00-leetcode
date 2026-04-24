// Last updated: 4/23/2026, 11:47:52 PM
1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int count = 0, add = 0;
4        for (char c : moves.toCharArray()) {
5            count += c == 'L' ? 1 : c == 'R' ? -1 : 0;
6            add += c == '_' ? 1 : 0;
7        }
8        return Math.abs(count) + add;
9    }
10}