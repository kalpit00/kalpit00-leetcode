// Last updated: 8/9/2025, 3:24:24 PM
class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[] map = new int[26];
        for (int i = 0; i < 3; i++) {
            for (char c : rows[i].toCharArray()) {
                map[c - 'a'] = i;
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (helper(word.toLowerCase(), map)) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }
    private boolean helper(String word, int[] map) {
        int x = map[word.charAt(0) - 'a'];
        for (char c : word.toCharArray()) {
            if (map[c - 'a'] != x) {
                return false;
            }
        }
        return true;
    }
}