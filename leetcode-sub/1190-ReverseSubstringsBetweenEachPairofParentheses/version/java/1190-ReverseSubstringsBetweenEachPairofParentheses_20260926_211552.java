// Last updated: 9/26/2026, 9:15:52 PM
1class Solution {
2    public String reverseParentheses(String s) {
3        Deque<StringBuilder> dq = new ArrayDeque<>();
4        for (char c : s.toCharArray()) {
5            if (c == '(') {
6                dq.push(new StringBuilder());
7            }
8            else if (c == ')') {
9                StringBuilder sb = dq.pop();
10                if (dq.isEmpty()) {
11                    dq.push(new StringBuilder());
12                }
13                dq.peek().append(sb.reverse());
14            }
15            else {
16                if (dq.isEmpty()) {
17                    dq.push(new StringBuilder());
18                }
19                dq.peek().append(c);
20            }
21        }
22        return dq.pop().toString();
23    }
24}