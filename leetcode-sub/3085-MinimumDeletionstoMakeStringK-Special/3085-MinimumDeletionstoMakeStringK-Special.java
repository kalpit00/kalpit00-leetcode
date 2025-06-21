// Last updated: 6/20/2025, 8:09:30 PM
class Solution {
    public int minimumDeletions(String word, int k) {
        int min = Integer.MAX_VALUE;
        int[] map = new int[26];
        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            int count = 0;
            for (int j = 0; j < 26; j++) {
                count += map[j] < map[i] ? map[j] : 
                Math.max(0, map[j] - map[i] - k);
            }
            min = Math.min(min, count);
        }
        return min;
    }
}