// Last updated: 4/17/2026, 8:42:04 PM
1class Solution {
2    public boolean checkDistances(String str, int[] distance) {
3        Integer[] map = new Integer[26];
4        char[] s = str.toCharArray();
5        int n = s.length;
6        for (int i = 0; i < n; i++) {
7            if (map[s[i] - 'a'] != null) {
8                if (i - map[s[i] - 'a'] - 1 != distance[s[i] - 'a']) {
9                    return false;
10                }
11            }
12            map[s[i] - 'a'] = i;
13        }
14        return true;
15    }
16}