// Last updated: 5/25/2025, 4:52:28 AM
class Solution {
    public int longestPalindrome(String[] words) {
        int count = 0;
        int[][] map = new int[26][26];
        for (String word : words) {
            int i = word.charAt(0) - 'a', j = word.charAt(1) - 'a';
            if (map[j][i] > 0) {
                count += 4;
                map[j][i]--;
            }
            else {
                map[i][j]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (map[i][i] > 0) {
                count += 2;
                break;
            }
        }
        return count;
    }
}