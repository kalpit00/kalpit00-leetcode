// Last updated: 8/30/2025, 4:23:40 AM
public class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> x = strStrAll(s, a), y = strStrAll(s, b);
        List<Integer> res = new ArrayList<>();
        int j = 0, m = y.size();
        for (int i : x) {
            while (j < m && y.get(j) < i - k) {
                j++;
            }
            if (j < m && y.get(j) <= i + k) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> strStrAll(String haystack, String needle) {
        List<Integer> result = new ArrayList<>();
        char[] text = haystack.toCharArray(), pattern = needle.toCharArray();
        int[] lps = buildLPS(pattern);
        int n = text.length, m = pattern.length, j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && text[i] != pattern[j]) {
                j = lps[j - 1];
            }
            j += (text[i] == pattern[j]) ? 1 : 0;
            if (j == m) {
                result.add(i + 1 - j);
                j = lps[j - 1];
            }
        }
        return result;
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