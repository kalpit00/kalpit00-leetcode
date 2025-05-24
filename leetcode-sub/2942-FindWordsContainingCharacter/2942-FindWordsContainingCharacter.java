// Last updated: 5/23/2025, 8:06:39 PM
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] s = words[i].toCharArray();
            int m = s.length;
            for (int j = 0; j < m; j++) {
                if (s[j] == x || s[m - j - 1] == x) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}