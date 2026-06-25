// Last updated: 6/25/2026, 3:13:41 AM
1class Solution {
2    public int deleteString(String s) {
3        int n = s.length();
4        Integer[] dp = new Integer[n];
5        return solve(0, n, s, dp);
6    }
7    private int solve(int idx, int n, String s, Integer[] dp) {
8        if (idx == n) return 0; // or s.length() == 0 || s.isEmpty()
9        if (dp[idx] != null) return dp[idx];
10        int[] lps = kmp(s);
11        int max = 1;
12        for (int i = 1; i < lps.length; i++) {
13            int j = (i + 1) / 2;
14            if (lps[i] == j && i % 2 == 1) {
15                max = Math.max(max, 1 + solve(idx + j, n,  s.substring(j), dp));
16            }
17        }
18        return dp[idx] = max;
19    }
20    private int[] kmp(String s) {
21        char[] p = s.toCharArray();
22        int[] lps = new int[p.length];
23        int j = 0;
24        for (int i = 1; i < p.length; i++) {
25            while (j > 0 && p[i] != p[j]) j = lps[j - 1];
26            lps[i] = (p[i] == p[j]) ? ++j : 0;
27        }
28        return lps;
29    }
30}