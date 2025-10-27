// Last updated: 10/26/2025, 8:18:17 PM
class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int n = words.length, count = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] map = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            count += map[i] / 2;
        }
        for (int i = 0; i < n; i++) {
            count -= words[i].length() / 2;
            if (count < 0) {
                return i;
            }
        }
        return n;
    }
}