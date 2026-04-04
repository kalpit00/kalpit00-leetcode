// Last updated: 4/3/2026, 8:38:00 PM
1class Solution {
2    public String decodeCiphertext(String encodedText, int rows) {
3        char[] s = encodedText.toCharArray();
4        int k = s.length, m = rows, n = k / m;
5        StringBuilder sb = new StringBuilder();
6        for (int i = 0; i < n; i++) {
7            for (int j = i; j < k; j += n + 1) {
8                sb.append(s[j]);
9            }
10        }
11        return sb.toString().stripTrailing();
12    }
13}