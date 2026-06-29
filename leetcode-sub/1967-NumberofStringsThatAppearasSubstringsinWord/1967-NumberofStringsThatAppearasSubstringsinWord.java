// Last updated: 6/29/2026, 2:04:45 AM
1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3        int count = 0;
4        for (String needle : patterns) {
5            count += strStr(word, needle) ? 1 : 0;
6        }
7        return count;
8    }
9    public boolean strStr(String haystack, String needle) {
10        if (needle.isEmpty()) return false;
11        char[] text = haystack.toCharArray(), pattern = needle.toCharArray();
12        int[] lps = buildLPS(pattern);
13        int n = text.length, m = pattern.length, j = 0;
14        for (int i = 0; i < n; i++) {
15            while (j > 0 && text[i] != pattern[j]) {
16                j = lps[j - 1];
17            }
18            j += (text[i] == pattern[j]) ? 1 : 0;
19            if (j == m) {
20                return true;
21            }
22        }
23        return false;
24    }
25    private int[] buildLPS(char[] pattern) {
26        int m = pattern.length, j = 0;
27        int[] lps = new int[m];
28        for (int i = 1; i < m; i++) {
29            while (j > 0 && pattern[i] != pattern[j]) {
30                j = lps[j - 1];
31            }
32            j += (pattern[i] == pattern[j]) ? 1 : 0;
33            lps[i] = j;
34        }
35        return lps;
36    }
37}