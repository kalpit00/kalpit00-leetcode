// Last updated: 10/12/2025, 8:05:27 PM
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int n = words.length;
        for (int i = 1; i < n; i++) {
            if (!helper(words[i], words[i - 1])) {
                res.add(words[i]);
            }
        }
        return res;
    }

    private boolean helper(String word1, String word2) {
        int[] map = new int[26];
        for (char ch : word1.toCharArray()) {
            map[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            map[ch - 'a']--;
        }
        for (int x : map) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}