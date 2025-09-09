// Last updated: 9/9/2025, 3:54:34 AM
class Solution {
    public int minValidStrings(String[] words, String target) {
        int n = words.length, k = target.length(), count = 0;
        List<int[]> list = new ArrayList<>();
        for (String word : words) {
            list.add(buildLPS((word + "#" + target).toCharArray()));
        } // precompute lps[] for str = (words[i] + '#' + target)
        while (k > 0) { // O(nk) = 10^5, is fine!
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, list.get(i)[words[i].length() + k]);
            } // take lps[words[i].len + k] to get MATCH of prefix = suffix
            if (max == 0) {
                return -1;
            }
            count++; // lower k by max!
            k -= max;
        } // this way, while k > 0 tries to match entire 'target' of length k!
        return count;
    }
    private int[] buildLPS(char[] pattern) {
        int m = pattern.length, j = 0;
        int[] lps = new int[m];
        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = lps[j - 1];
            }
            lps[i] = (pattern[i] == pattern[j]) ? ++j : 0;
        }
        return lps;
    }
}