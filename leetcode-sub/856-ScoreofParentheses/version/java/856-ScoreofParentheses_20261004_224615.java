// Last updated: 10/4/2026, 10:46:15 PM
1class Solution {
2    public int scoreOfParentheses(String S) {
3        Stack<Integer> stack = new Stack<>();
4        stack.push(0);
5        for (char c : S.toCharArray()) {
6            if (c == '(') {
7                stack.push(0);
8            } 
9            else {
10                int v = stack.pop();
11                int w = stack.pop();
12                stack.push(w + Math.max(2 * v, 1));
13            }
14        }
15        return stack.pop();
16    }
17}