// Last updated: 3/7/2026, 8:22:41 PM
1class Solution {
2    int timer = 0;
3    public boolean[] findAnswer(int[] parent, String str) {
4        int n = parent.length;
5        char[] s = str.toCharArray(), dfsStr = new char[n];
6        int[] d = new int[n], f = new int[n];
7        List<List<Integer>> adj = new ArrayList<>();
8        for (int i = 0; i < n; i++) {
9            adj.add(new ArrayList<>());
10        }
11        for (int i = 1; i < n; i++) {
12            adj.get(parent[i]).add(i);
13        }
14        dfs(0, adj, s, dfsStr, d, f);
15        boolean[] res = new boolean[n];
16        int[] p = manacher(convert(dfsStr));
17        for (int i = 0; i < n; i++) {
18            res[i] = isPalindrome(d[i], f[i], p);
19        }
20        return res;
21    }
22    private void dfs(int node, List<List<Integer>> adj, 
23    char[] s, char[] dfsStr, int[] d, int[] f) {
24        d[node] = timer;
25        for (int child : adj.get(node)) {
26            dfs(child, adj, s, dfsStr, d, f);
27        }
28        dfsStr[timer] = s[node]; // postorder, l -> r -> node!
29        f[node] = timer;
30        timer++;
31    }
32    private char[] convert(char[] s) {
33        int n = s.length * 2 + 3;
34        char[] arr = new char[n];
35        int idx = 0;
36        arr[idx++] = '@';
37        arr[idx++] = '#';
38        for (char c : s) {
39            arr[idx++] = c;
40            arr[idx++] = '#';
41        }
42        arr[n - 1] = '$';
43        return arr;
44    }
45
46    private int[] manacher(char[] arr) {
47        int n = arr.length;
48        int[] p = new int[n];
49        int center = 0, maxRight = 0;
50        for (int i = 0; i < n; i++) {
51            int mirror = 2 * center - i;
52            if (i < maxRight) {
53                p[i] = Math.min(maxRight - i, p[mirror]);
54            }
55            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n &&
56                   arr[i - p[i] - 1] == arr[i + p[i] + 1]) {
57                p[i]++;
58            }
59            if (i + p[i] > maxRight) {
60                center = i;
61                maxRight = i + p[i];
62            }
63        }
64        return p;
65    }
66
67    private boolean isPalindrome(int i, int j, int[] p) {
68        int left = 2 * i + 2, right = 2 * j + 2;
69        int center = (left + right) / 2;
70        return p[center] >= (right - left) / 2;
71    }
72}