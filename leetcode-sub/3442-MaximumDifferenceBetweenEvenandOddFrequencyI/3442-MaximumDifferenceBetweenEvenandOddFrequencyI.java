// Last updated: 6/9/2025, 8:07:03 PM
class Solution {
    public int maxDifference(String s) {
        int maxOdd = 0, minEven = Integer.MAX_VALUE;
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            maxOdd = map[i] % 2 == 1 ? Math.max(maxOdd, map[i]) : maxOdd;
            minEven = map[i] != 0 && map[i] % 2 == 0 ? Math.min(minEven, map[i]) : minEven;
        }
        return maxOdd - minEven;
    }
}