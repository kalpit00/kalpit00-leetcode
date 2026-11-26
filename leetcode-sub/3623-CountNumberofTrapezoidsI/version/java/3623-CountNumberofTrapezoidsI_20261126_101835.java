// Last updated: 11/26/2026, 10:18:35 AM
1
2class Solution {
3    public boolean canChoose(int[][] groups, int[] nums) {
4        int start = 0;
5        for (int[] group : groups) {
6            start = strStr(nums, group, start);
7            if (start == -1) return false;
8        }
9        return true;
10    }
11    private int strStr(int[] text, int[] pattern, int start) {
12        int[] lps = kmp(pattern);
13        int n = text.length, m = pattern.length, j = 0;
14        for (int i = start; i < n; i++) {
15            while (j > 0 && text[i] != pattern[j]) {
16                j = lps[j - 1];
17            }
18            j += (text[i] == pattern[j]) ? 1 : 0;
19            if (j == m) {
20                return i + 1;
21            }
22        }
23        return -1;
24    }
25
26    private int[] kmp(int[] pattern) {
27        int m = pattern.length, j = 0;
28        int[] lps = new int[m];
29        for (int i = 1; i < m; i++) {
30            while (j > 0 && pattern[i] != pattern[j]) {
31                j = lps[j - 1];
32            }
33            j += (pattern[i] == pattern[j]) ? 1 : 0;
34            lps[i] = j;
35        }
36        return lps;
37    }
38}
39