// Last updated: 10/20/2025, 5:57:15 AM
class Solution {
    public int countOfSubstrings(String word, int k) {
        return helper(word, k) - helper(word, k - 1);
    }

    public int helper(String word, int k) {
        char[] s = word.toCharArray();
        int n = s.length, left = 0, right = 0, vowels = 0, consonants = 0;
        int[] map = new int[26];
        int count = 0;
        while (right < n) {
            map[s[right] - 'a']++;
            if (isVowel(s[right])) {
                vowels += map[s[right] - 'a'] == 1 ? 1 : 0;
            }
            else {
                consonants++;
            }
            right++;
            while (vowels >= 5 && consonants > k) {
                if (isVowel(s[left])) {
                    vowels -= map[s[left] - 'a'] == 1 ? 1 : 0;
                }
                else {
                    consonants--;
                }
                map[s[left] - 'a']--;
                left++;
            }
            count += right - left;
        }
        return count;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}