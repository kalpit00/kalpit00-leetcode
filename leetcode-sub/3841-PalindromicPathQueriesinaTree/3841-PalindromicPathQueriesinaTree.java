// Last updated: 3/24/2026, 5:27:14 AM
1class Solution {
2    int timer = 0, idx = 0;
3    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
4        List<List<Integer>> adj = new ArrayList<>();
5        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
6        for (int[] edge : edges) {
7            int u = edge[0], v = edge[1];
8            adj.get(u).add(v);
9            adj.get(v).add(u);
10        }
11        char[] arr = s.toCharArray();
12        int[] d = new int[n], f = new int[n], first = new int[n], 
13        depth = new int[n], base = new int[n], euler = new int[2 * n - 1];
14        dfs(0, -1, 0, 0, adj, arr, d, f, first, depth, base, euler);
15        SparseTable st = new SparseTable(euler, depth);
16        FenwickTree bit = new FenwickTree(n);
17        List<Boolean> ans = new ArrayList<>();
18        for (String q : queries) {
19            String[] p = q.split(" ");
20            if (p[0].equals("update")) {
21                int u = Integer.parseInt(p[1]);
22                char c = p[2].charAt(0);
23                if (arr[u] == c) continue;                
24                int delta = (1 << (arr[u] - 'a')) ^ (1 << (c - 'a'));
25                bit.rangeUpdate(d[u], f[u], delta);
26                arr[u] = c;
27            } 
28            else {
29                int u = Integer.parseInt(p[1]), v = Integer.parseInt(p[2]);
30                int w = st.query(first[u], first[v]);
31                int mask = (base[u] ^ bit.query(d[u])) ^ (base[v] ^ 
32                bit.query(d[v])) ^ (1 << (arr[w] - 'a'));
33                ans.add((mask & (mask - 1)) == 0);
34            }
35        }
36        return ans;
37    }
38    class SparseTable {
39        int[][] table;
40        int[] depth;
41        int n, k;
42        public SparseTable(int[] nums, int[] depth) {
43            this.depth = depth;
44            n = nums.length;
45            k = (int) (Math.log(n) / Math.log(2)) + 1;
46            table = new int[n][k];
47            for (int i = 0; i < n; i++) {
48                table[i][0] = nums[i];
49            }
50            for (int j = 1; j < k; j++) {
51                for (int i = 0; i + (1 << j) <= n; i++) {
52                    int a = table[i][j - 1];
53                    int b = table[i + (1 << (j - 1))][j - 1];
54                    table[i][j] = depth[a] <= depth[b] ? a : b;
55                }
56            }
57        }
58        public int query(int l, int r) {
59            if (l > r) return query(r, l);
60            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
61            int a = table[l][x], b = table[r - (1 << x) + 1][x];
62            return depth[a] <= depth[b] ? a : b;
63        }
64    }
65
66    class FenwickTree {
67        int[] tree;
68        int n;
69        public FenwickTree(int n) {
70            this.n = n;
71            tree = new int[n + 2];
72        }
73        public int query(int index) {
74            int ans = 0;
75            index++;
76            while (index > 0) {
77                ans ^= tree[index];
78                index -= index & -index;
79            }
80            return ans;
81        }
82        public void update(int index, int val) {
83            index++;
84            while (index < tree.length) {
85                tree[index] ^= val;
86                index += index & -index;
87            }
88        }
89        public void rangeUpdate(int l, int r, int val) {
90            update(l, val);
91            update(r + 1, val);
92        }
93    }
94
95    private void dfs(int u, int p, int dep, int mask, List<List<Integer>> adj, char[] s, int[] d, int[] f, int[] first, int[] depth, int[] base, int[] euler) {
96        d[u] = timer++;
97        depth[u] = dep;
98        base[u] = mask ^ (1 << (s[u] - 'a'));
99        first[u] = idx;
100        euler[idx++] = u;
101        for (int v : adj.get(u)) {
102            if (v == p) continue;
103            dfs(v, u, dep + 1, base[u], adj, s, d, f, first, depth, base, euler);
104            euler[idx++] = u;
105        }
106        f[u] = timer - 1;
107    }
108}