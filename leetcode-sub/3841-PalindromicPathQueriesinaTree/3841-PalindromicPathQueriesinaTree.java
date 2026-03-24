// Last updated: 3/24/2026, 5:23:55 AM
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
21                int u = Integer.parseInt(p[1]), delta;
22                char c = p[2].charAt(0);
23                if (arr[u] == c) continue;
24                delta = (1 << (arr[u] - 'a')) ^ (1 << (c - 'a'));
25                bit.rangeUpdate(d[u], f[u], delta);
26                arr[u] = c;
27            } else {
28                int u = Integer.parseInt(p[1]), v = Integer.parseInt(p[2]), l = first[u], r = first[v];
29                if (l > r) {
30                    int t = l;
31                    l = r;
32                    r = t;
33                }
34                int w = st.query(l, r);
35                int mask = (base[u] ^ bit.query(d[u])) ^ (base[v] ^ bit.query(d[v])) ^ (1 << (arr[w] - 'a'));
36                ans.add((mask & (mask - 1)) == 0);
37            }
38        }
39        return ans;
40    }
41    class SparseTable {
42        int[][] table;
43        int[] depth;
44        int n, k;
45        public SparseTable(int[] nums, int[] depth) {
46            this.depth = depth;
47            n = nums.length;
48            k = (int) (Math.log(n) / Math.log(2)) + 1;
49            table = new int[n][k];
50            for (int i = 0; i < n; i++) {
51                table[i][0] = nums[i];
52            }
53            for (int j = 1; j < k; j++) {
54                for (int i = 0; i + (1 << j) <= n; i++) {
55                    int a = table[i][j - 1];
56                    int b = table[i + (1 << (j - 1))][j - 1];
57                    table[i][j] = depth[a] <= depth[b] ? a : b;
58                }
59            }
60        }
61        public int query(int l, int r) {
62            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
63            int a = table[l][x], b = table[r - (1 << x) + 1][x];
64            return depth[a] <= depth[b] ? a : b;
65        }
66    }
67
68    class FenwickTree {
69        int[] tree;
70        int n;
71
72        public FenwickTree(int n) {
73            this.n = n;
74            tree = new int[n + 2];
75        }
76
77        public int query(int index) {
78            int ans = 0;
79            index++;
80            while (index > 0) {
81                ans ^= tree[index];
82                index -= index & -index;
83            }
84            return ans;
85        }
86
87        public void update(int index, int val) {
88            index++;
89            while (index < tree.length) {
90                tree[index] ^= val;
91                index += index & -index;
92            }
93        }
94
95        public void rangeUpdate(int l, int r, int val) {
96            update(l, val);
97            update(r + 1, val);
98        }
99    }
100
101    private void dfs(int u, int p, int dep, int mask, List<List<Integer>> adj, char[] s, int[] d, int[] f, int[] first, int[] depth, int[] base, int[] euler) {
102        d[u] = timer++;
103        depth[u] = dep;
104        base[u] = mask ^ (1 << (s[u] - 'a'));
105        first[u] = idx;
106        euler[idx++] = u;
107        for (int v : adj.get(u)) {
108            if (v == p) continue;
109            dfs(v, u, dep + 1, base[u], adj, s, d, f, first, depth, base, euler);
110            euler[idx++] = u;
111        }
112        f[u] = timer - 1;
113    }
114}