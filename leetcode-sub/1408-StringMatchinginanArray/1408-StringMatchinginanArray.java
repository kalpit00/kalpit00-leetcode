// Last updated: 6/29/2026, 2:29:11 AM
1class Solution {
2    public List<String> stringMatching(String[] words) {
3        List<String> res = new ArrayList<>();
4        int n = words.length;
5        for (int i = 0; i < n; i++) {
6            for (int j = 0; j < n; j++) {
7                if (i == j) continue;
8                if (kmp(words[j], words[i])) {
9                    res.add(words[i]);
10                    break;
11                }
12            }
13        }
14        return res;
15    }
16    public boolean kmp(String haystack, String needle) {
17        char[] text = haystack.toCharArray(), pattern = needle.toCharArray();
18        int[] lps = buildLPS(pattern);
19        int n = text.length, m = pattern.length, j = 0;
20        for (int i = 0; i < n; i++) {
21            while (j > 0 && text[i] != pattern[j]) {
22                j = lps[j - 1];
23            }
24            j+= (text[i] == pattern[j]) ? 1 : 0;
25            if (j == m) {
26                return true;
27            }
28        }
29        return false;
30    }
31    private int[] buildLPS(char[] pattern) {
32        int m = pattern.length, j = 0;
33        int[] lps = new int[m];
34        for (int i = 1; i < m; i++) {
35            while (j > 0 && pattern[i] != pattern[j]) {
36                j = lps[j - 1];
37            }
38            lps[i] = (pattern[i] == pattern[j]) ? ++j : 0;
39        }
40        return lps;
41    }
42}