// Last updated: 6/9/2025, 8:07:36 PM
class Solution {
    public int maxDifference(String s) {
        int max = 0, min = Integer.MAX_VALUE;
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            max = map[i] % 2 == 1 ? Math.max(max, map[i]) : max;
            min = map[i] != 0 && map[i] % 2 == 0 ? Math.min(min, map[i]) : min;
        }
        return max - min;
    }
}