// Last updated: 5/25/2026, 9:04:42 PM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        boolean[] map = new boolean[123];
4        for (char c : word.toCharArray()) {
5            map[c] = true;
6        }
7        int count = 0;
8        for (int i = 0; i < 26; i++) {
9            count += map[(int) 'A' + i] && map[(int) 'a' + i] ? 1 : 0;
10        }
11        return count;
12    }
13}