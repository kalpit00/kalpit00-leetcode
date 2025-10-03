// Last updated: 10/3/2025, 6:20:53 AM
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length, m = queries.length;
        int[] pre = new int[n + 1], res = new int[m];
        for (int i = 0; i < n; i++) {
            int val = isVowel(words[i].charAt(0)) && 
            isVowel(words[i].charAt(words[i].length() - 1)) ? 1 : 0;
            pre[i + 1] = pre[i] + val;
        }
        for (int i = 0; i < m; i++) {
            res[i] = pre[queries[i][1] + 1] - pre[queries[i][0]];
        }
        return res;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}