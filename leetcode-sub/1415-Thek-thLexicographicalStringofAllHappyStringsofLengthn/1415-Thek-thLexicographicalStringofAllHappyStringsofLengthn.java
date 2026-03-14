// Last updated: 3/14/2026, 1:16:18 AM
1class Solution {
2    int count = 0;
3    String res = "";
4    public String getHappyString(int n, int k) {
5        char[] arr = "abc".toCharArray();
6        StringBuilder sb = new StringBuilder();
7        dfs(n, k, arr, 0, sb);
8        if (count < k) {
9            return "";
10        }
11        return res;
12    }
13
14    private void dfs(int n, int k, char[] arr, int idx, StringBuilder sb) {
15        if (sb.length() == n) {
16            if (count == k) {
17                res = sb.toString();
18            }
19            return;
20        }
21        for (int i = 0; i < 3; i++) {
22            if (sb.length() != 0 && sb.charAt(idx - 1) == arr[i]) {
23                continue;
24            }
25            sb.append(arr[i]);
26            if (sb.length() == n) {
27                count++;
28            }
29            dfs(n, k, arr, idx + 1, sb);
30            if (!res.isEmpty()) {
31                return;
32            }
33            sb.deleteCharAt(sb.length() - 1);
34        }
35    }
36}