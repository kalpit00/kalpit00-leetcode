// Last updated: 3/30/2026, 4:18:52 PM
1class Solution {
2    public boolean checkStrings(String s, String t) {
3        int[] oddMap1 = new int[26], evenMap1 = new int[26];
4        int[] oddMap2 = new int[26], evenMap2 = new int[26];
5        char[] s1 = s.toCharArray(), s2 = t.toCharArray();
6        int n = s1.length;
7        for (int i = 0; i < n; i++) {
8            if (i % 2 == 0) {
9                evenMap1[s1[i] - 'a']++;
10                evenMap2[s2[i] - 'a']++;
11            }
12            else {
13                oddMap1[s1[i] - 'a']++;
14                oddMap2[s2[i] - 'a']++;
15            }
16        }
17        return helper(oddMap1, oddMap2) && helper(evenMap1, evenMap2);
18    }
19    private boolean helper(int[] map1, int[] map2) {
20        for (int i = 0; i < 26; i++) {
21            if (map1[i] != map2[i]) {
22                return false;
23            }
24        }
25        return true;
26    }
27}