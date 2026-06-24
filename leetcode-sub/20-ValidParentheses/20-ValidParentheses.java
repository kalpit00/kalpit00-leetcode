// Last updated: 6/23/2026, 10:07:01 PM
1class Solution {
2    public boolean isValid(String str) {
3        int top = -1, n = str.length();
4        char[] stack = new char[n], s = str.toCharArray();
5        for (int i = 0; i < n; i++) {
6            if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
7                stack[++top] = s[i];
8            }
9            else if (top == -1) {
10                return false;
11            }
12            else if (s[i] == ')' && stack[top--] != '(') {
13                return false;
14            }
15            else if (s[i] == '}' && stack[top--] != '{') {
16                return false;
17            }
18            else if (s[i] == ']' && stack[top--] != '[') {
19                return false;
20            }
21        }
22        return top == -1;
23    }
24}