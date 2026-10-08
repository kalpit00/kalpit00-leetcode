// Last updated: 10/7/2026, 8:14:56 PM
1class Solution {
2    public String removeOuterParentheses(String s) {
3        Stack<Character> stack = new Stack<>();
4        StringBuilder sb = new StringBuilder();
5        for (char c : s.toCharArray()) {
6            if (c == '(') {
7                if (stack.size() > 0) {
8                    sb.append(c);
9                }
10                stack.push(c);
11            }
12            else {
13                stack.pop();
14                if (stack.size() > 0) {
15                    sb.append(c);
16                }
17            }
18        }
19        return sb.toString();
20    }
21}