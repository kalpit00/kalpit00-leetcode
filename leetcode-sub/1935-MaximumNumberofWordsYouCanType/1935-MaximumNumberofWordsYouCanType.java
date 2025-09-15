// Last updated: 9/14/2025, 9:08:43 PM
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        boolean[] map = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            map[c - 'a'] = true;
        }
        outer:  
        for (String word : text.split(" ")) {
            for (char c : word.toCharArray()) {
                if (map[c - 'a']) continue outer;
            }
            count++;
        }
        return count;
    }
}