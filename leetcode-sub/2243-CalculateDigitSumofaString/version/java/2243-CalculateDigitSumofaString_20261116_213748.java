// Last updated: 11/16/2026, 9:37:48 PM
1class Solution {
2
3    public String digitSum(String s, int k) {
4        while (s.length() > k) {
5            StringBuilder tmp = new StringBuilder(); // The string after each round
6            int n = s.length();
7            for (int i = 0; i < n; i += k) {
8                int val = 0;
9                for (int j = i; j < Math.min(i + k, n); ++j) {
10                    val += s.charAt(j) - '0';
11                }
12                tmp.append(val);
13            }
14            s = tmp.toString();
15        }
16        return s;
17    }
18}