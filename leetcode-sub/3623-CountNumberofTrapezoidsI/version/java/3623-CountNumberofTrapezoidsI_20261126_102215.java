// Last updated: 11/26/2026, 10:22:15 AM
1class Solution {
2    public boolean canChoose(int[][] groups, int[] nums) {
3        int idx = 0;
4        for (int[] group : groups) {
5            idx = strStr(nums, group, idx); // using i = idx, not i = 0 -> O(m+n)
6            if (idx == -1) return false;
7        }
8        return true;
9    }
10    private int strStr(int[] text, int[] pattern, int idx) {
11        int[] lps = kmp(pattern);
12        int n = text.length, m = pattern.length, j = 0;
13        for (int i = idx; i < n; i++) { // start from i = idx in text
14            while (j > 0 && text[i] != pattern[j]) {
15                j = lps[j - 1];
16            }
17            j += (text[i] == pattern[j]) ? 1 : 0;
18            if (j == m) {
19                return i + 1; // NOT i + 1 - j => [0 .. (j ... 'i+1') .. n]
20            } // index when substr match ends, NOT starts. so dont do '-j' 
21        }
22        return -1;
23    }
24
25    private int[] kmp(int[] pattern) {
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
38