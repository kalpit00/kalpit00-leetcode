// Last updated: 3/29/2026, 11:11:10 PM
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
17        return helper(oddMap1, evenMap1, oddMap2, evenMap2);
18    }
19    private boolean helper(int[] oddMap1, int[] evenMap1, 
20    int[] oddMap2, int[] evenMap2) {
21        for (int i = 0; i < 26; i++) {
22            if (oddMap1[i] != oddMap2[i] || evenMap1[i] != evenMap2[i]) {
23                return false;
24            }
25        }
26        return true;
27    }
28}