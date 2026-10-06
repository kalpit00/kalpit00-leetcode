// Last updated: 10/5/2026, 10:46:42 PM
1class Solution {
2    public int minAddToMakeValid(String s) {
3        int openBrackets = 0, minAddsRequired = 0;
4        for (char c : s.toCharArray()) {
5            if (c == '(') {
6                openBrackets++;
7            } else {
8                if (openBrackets > 0) {
9                    openBrackets--;
10                } else {
11                    minAddsRequired++;
12                }
13            }
14        }
15        return minAddsRequired + openBrackets;
16    }
17}