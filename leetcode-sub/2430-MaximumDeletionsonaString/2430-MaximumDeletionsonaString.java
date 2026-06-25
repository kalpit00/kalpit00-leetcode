// Last updated: 6/25/2026, 12:40:42 AM
1class Solution {
2    public int deleteString(String s) {
3        Map<String, Integer> dp = new HashMap<>();
4        return solve(s, dp);
5    }
6    private int solve(String s, Map<String, Integer> dp) {
7        if (s.length() == 0) return 0;
8        if (dp.containsKey(s)) return dp.get(s);
9        int[] lps = kmp(s);
10        int max = 1;
11        for (int i = 1; i < lps.length; i++) {
12            int j = (i + 1) / 2;
13            if (lps[i] == j && i % 2 == 1) {
14                max = Math.max(max, 1 + solve(s.substring(j), dp));
15            }
16        }
17        dp.put(s, max);
18        return max;
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