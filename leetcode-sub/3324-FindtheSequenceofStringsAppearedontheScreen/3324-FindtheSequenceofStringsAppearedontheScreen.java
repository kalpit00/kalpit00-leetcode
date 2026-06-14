// Last updated: 6/13/2026, 10:15:11 PM
1class Solution {
2    public List<String> stringSequence(String target) {
3        List<String> res = new ArrayList<>();
4        int n = target.length();
5        char[] s = new char[n], t = target.toCharArray();
6        for (int i = 0; i < n; i++) {
7            for (char c = 'a'; c <= t[i]; c++) {
8                s[i] = c;
9                res.add(new String(s).trim());
10            }
11        }
12        return res;
13    }
14}