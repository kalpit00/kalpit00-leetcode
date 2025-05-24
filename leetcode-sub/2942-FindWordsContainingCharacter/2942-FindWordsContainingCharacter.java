// Last updated: 5/23/2025, 8:03:46 PM
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                if (c == x) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}