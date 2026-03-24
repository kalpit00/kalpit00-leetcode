// Last updated: 3/24/2026, 5:22:25 AM
1import java.util.*;
2
3class Solution {
4    int timer, idx;
5    int[] d, f, first, depth, base, euler;
6    char[] arr;
7    List<List<Integer>> adj;
8
9    class SparseTable {
10        int[][] table;
11        int k, n;
12        int[] depth;
13
14        public SparseTable(int[] nums, int[] depth) {
15            this.depth = depth;
16            n = nums.length;
17            k = (int) (Math.log(n) / Math.log(2)) + 1;
18            table = new int[n][k];
19            for (int i = 0; i < n; i++) table[i][0] = nums[i];
20            for (int j = 1; j < k; j++) {
21                for (int i = 0; i + (1 << j) <= n; i++) {
22                    int a = table[i][j - 1], b = table[i + (1 << (j - 1))][j - 1];
23                    table[i][j] = depth[a] <= depth[b] ? a : b;
24                }
25            }
26        }
27
28        public int query(int l, int r) {
29            if (l > r) return -1;
30            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
31            int a = table[l][x], b = table[r - (1 << x) + 1][x];
32            return depth[a] <= depth[b] ? a : b;
33        }
34    }
35
36    class FenwickTree {
37        int[] tree;
38        int n;
39
40        public FenwickTree(int n) {
41            this.n = n;
42            tree = new int[n + 2];
43        }
44
45        public int query(int index) {
46            int ans = 0;
47            index++;
48            while (index > 0) {
49                ans ^= tree[index];
50                index -= index & -index;
51            }
52            return ans;
53        }
54
55        public void update(int index, int val) {
56            index++;
57            while (index < tree.length) {
58                tree[index] ^= val;
59                index += index & -index;
60            }
61        }
62
63        public void rangeUpdate(int left, int right, int val) {
64            update(left, val);
65            update(right + 1, val);
66        }
67    }
68
69    private void dfs(int node, int par, int dep, int mask) {
70        d[node] = timer++;
71        depth[node] = dep;
72        base[node] = mask ^ (1 << (arr[node] - 'a'));
73        first[node] = idx;
74        euler[idx++] = node;
75
76        for (int child : adj.get(node)) {
77            if (child == par) continue;
78            dfs(child, node, dep + 1, base[node]);
79            euler[idx++] = node;
80        }
81
82        f[node] = timer - 1;
83    }
84
85    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
86        arr = s.toCharArray();
87        adj = new ArrayList<>();
88        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
89        for (int[] e : edges) {
90            adj.get(e[0]).add(e[1]);
91            adj.get(e[1]).add(e[0]);
92        }
93
94        d = new int[n];
95        f = new int[n];
96        first = new int[n];
97        depth = new int[n];
98        base = new int[n];
99        euler = new int[2 * n - 1];
100        timer = 0;
101        idx = 0;
102
103        dfs(0, -1, 0, 0);
104
105        SparseTable st = new SparseTable(euler, depth);
106        FenwickTree bit = new FenwickTree(n);
107        List<Boolean> ans = new ArrayList<>();
108
109        for (String q : queries) {
110            String[] p = q.split(" ");
111            if (p[0].equals("update")) {
112                int u = Integer.parseInt(p[1]);
113                char c = p[2].charAt(0);
114                if (arr[u] == c) continue;
115                int delta = (1 << (arr[u] - 'a')) ^ (1 << (c - 'a'));
116                bit.rangeUpdate(d[u], f[u], delta);
117                arr[u] = c;
118            } else {
119                int u = Integer.parseInt(p[1]);
120                int v = Integer.parseInt(p[2]);
121                int l = first[u], r = first[v];
122                if (l > r) {
123                    int t = l;
124                    l = r;
125                    r = t;
126                }
127                int w = st.query(l, r);
128                int mask = (base[u] ^ bit.query(d[u])) ^ (base[v] ^ bit.query(d[v])) ^ (1 << (arr[w] - 'a'));
129                ans.add((mask & (mask - 1)) == 0);
130            }
131        }
132
133        return ans;
134    }
135}