// Last updated: 9/14/2025, 9:09:32 PM
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        boolean[] map = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            map[c - 'a'] = true;
        }
        for (String word : text.split(" ")) {
            boolean flag = false;
            for (char c : word.toCharArray()) {
                if (map[c - 'a']) {
                    flag = true;
                    break;
                }
            }
            count += !flag ? 1 : 0;
        }
        return count;
    }
}