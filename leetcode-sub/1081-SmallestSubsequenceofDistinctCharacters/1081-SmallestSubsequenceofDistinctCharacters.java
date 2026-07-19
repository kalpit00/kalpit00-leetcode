// Last updated: 7/19/2026, 5:26:03 AM
1class Solution {
2    public String smallestSubsequence(String s) {
3        int n = s.length(), mask = 0, top = -1;
4        int[] stack = new int[n], last = new int[26];
5        char[] arr = s.toCharArray();
6        for (int i = 0; i < n; i++) {
7            last[arr[i] - 'a'] = i;
8        }
9        for (int i = 0; i < n; i++) {
10            if ((mask & (1 << arr[i] - 'a')) != 0) {
11                continue;
12            }
13            while (top >= 0 && stack[top] > arr[i] - 'a' && 
14            last[stack[top]] > i) {
15                mask ^= 1 << stack[top];
16                top--;
17            }
18            stack[++top] = arr[i] - 'a';
19            mask |= 1 << stack[top];
20        }
21        StringBuilder sb = new StringBuilder();
22        for (int i = 0; i <= top; i++) {
23            sb.append((char) ('a' + stack[i]));
24        }
25        return sb.toString();
26    }
27}