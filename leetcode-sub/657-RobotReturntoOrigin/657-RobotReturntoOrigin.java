// Last updated: 4/5/2026, 2:32:53 AM
1class Solution {
2    public boolean judgeCircle(String moves) {
3        int[] freq = new int[26];
4        for (char c : moves.toCharArray()) {
5            freq[c - 'A']++;
6        }
7        return freq['U' - 'A'] == freq['D' - 'A'] && freq['L' - 'A'] == freq['R' - 'A'];
8    }
9}