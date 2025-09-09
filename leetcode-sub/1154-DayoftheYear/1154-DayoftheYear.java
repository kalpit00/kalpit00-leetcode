// Last updated: 9/9/2025, 3:43:22 AM
class Solution {
    public int minValidStrings(String[] words, String target) {
        int n = words.length, k = target.length(), count = 0;
        List<int[]> list = new ArrayList<>();
        for (String word : words) {
            list.add(buildLPS((word + "#" + target).toCharArray()));
        }
        while (k > 0) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, list.get(i)[words[i].length() + k]);
            }
            if (max == 0) {
                return -1;
            }
            count++;
            k -= max;
        }
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