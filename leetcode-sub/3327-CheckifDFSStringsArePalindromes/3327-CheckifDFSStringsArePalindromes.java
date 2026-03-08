// Last updated: 3/7/2026, 8:00:37 PM
1class Solution {
2    int idx = 0;
3    public boolean[] findAnswer(int[] parent, String str) {
4        int n = parent.length;
5        char[] s = str.toCharArray(), dfsStr = new char[n];
6        List<List<Integer>> adj = new ArrayList<>();
7        for (int i = 0; i < n; i++) {
8            adj.add(new ArrayList<>());
9        }
10        for (int i = 1; i < n; i++) {
11            adj.get(parent[i]).add(i);
12        }
13        int[][] range = new int[n][2];
14        dfs(0, adj, s, dfsStr, range);
15        boolean[] res = new boolean[n];
16        int[] p = manacher(convert(dfsStr));
17        for (int i = 0; i < n; i++) {
18            int l = range[i][0], r = range[i][1];
19// System.out.println(l + ", " + r + ", " + new String(dfsStr, l, r - l + 1));
20            res[i] = isPalindrome(l, r, p);
21        }
22        return res;
23    }
24    private void dfs(int node, List<List<Integer>> adj, 
25    char[] s, char[] dfsStr, int[][] range) {
26        range[node][0] = idx;
27        for (int child : adj.get(node)) {
28            dfs(child, adj, s, dfsStr, range);
29        }
30        dfsStr[idx] = s[node];
31        range[node][1] = idx;
32        idx++;
33    }
34    private char[] convert(char[] s) {
35        int n = s.length * 2 + 3;
36        char[] arr = new char[n];
37        int idx = 0;
38        arr[idx++] = '@';
39        arr[idx++] = '#';
40        for (char c : s) {
41            arr[idx++] = c;
42            arr[idx++] = '#';
43        }
44        arr[n - 1] = '$';
45        return arr;
46    }
47
48    private int[] manacher(char[] arr) {
49        int n = arr.length;
50        int[] p = new int[n];
51        int center = 0, maxRight = 0;
52        for (int i = 0; i < n; i++) {
53            int mirror = 2 * center - i;
54            if (i < maxRight) {
55                p[i] = Math.min(maxRight - i, p[mirror]);
56            }
57            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n &&
58                   arr[i - p[i] - 1] == arr[i + p[i] + 1]) {
59                p[i]++;
60            }
61            if (i + p[i] > maxRight) {
62                center = i;
63                maxRight = i + p[i];
64            }
65        }
66        return p;
67    }
68
69    private boolean isPalindrome(int i, int j, int[] p) {
70        int left = 2 * i + 2, right = 2 * j + 2;
71        int center = (left + right) / 2;
72        return p[center] >= (right - left) / 2;
73    }
74}