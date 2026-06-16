// Last updated: 6/16/2026, 2:03:42 AM
1class Solution {
2    public String processStr(String s) {
3        StringBuilder sb = new StringBuilder();
4        for (char c : s.toCharArray()) {
5            if (Character.isLetter(c)) {
6                sb.append(c);
7            }
8            else if (c == '*') {
9                if (sb.length() > 0) sb.setLength(sb.length() - 1);
10            }
11            else if (c == '#') {
12                StringBuilder temp = new StringBuilder(sb);
13                temp.append(sb);
14                sb = temp;
15            }
16            else {
17                StringBuilder temp = new StringBuilder(sb);
18                temp.reverse();
19                sb = temp;
20            }
21        }
22        return sb.toString();
23    }
24}