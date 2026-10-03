// Last updated: 10/3/2026, 3:45:45 AM
1class Solution {
2    public int longestValidParentheses(String str) {
3        char[] s = str.toCharArray();
4        Stack<Integer> stack = new Stack<>();
5        int max = 0;
6        for (int i = 0; i < s.length; i++) {
7            if (s[i] == '(' || !(!stack.isEmpty() && s[stack.peek()] == '(')) {
8                stack.push(i);
9                continue;
10            }
11            if (!stack.isEmpty() && s[stack.peek()] == '(') {
12                stack.pop();
13                int len = stack.isEmpty() ? i + 1 : i - stack.peek();
14                max = Math.max(max, len);
15            }
16        }
17        return max;
18    }
19}