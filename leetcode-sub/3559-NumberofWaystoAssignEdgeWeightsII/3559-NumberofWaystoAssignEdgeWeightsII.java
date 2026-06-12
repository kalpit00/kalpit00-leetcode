// Last updated: 6/12/2026, 5:27:11 AM
1class Solution {
2    int MOD = 1000000007;
3
4    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
5        int n = edges.length + 1, m = queries.length;
6
7        List<List<Integer>> adj = new ArrayList<>();
8        List<List<int[]>> q = new ArrayList<>();
9
10        for (int i = 0; i <= n; i++) {
11            adj.add(new ArrayList<>());
12            q.add(new ArrayList<>());
13        }
14
15        for (int[] edge : edges) {
16            int u = edge[0], v = edge[1];
17            adj.get(u).add(v);
18            adj.get(v).add(u);
19        }
20
21        for (int i = 0; i < m; i++) {
22            int u = queries[i][0], v = queries[i][1];
23            q.get(u).add(new int[]{v, i});
24            q.get(v).add(new int[]{u, i});
25        }
26
27        int[] depth = new int[n + 1];
28        int[] visited = new int[n + 1];
29        int[] lca = new int[m];
30        int[] ancestor = new int[n + 1];
31
32        DSU dsu = new DSU(n + 1);
33        for (int i = 0; i <= n; i++) {
34            ancestor[i] = i;
35        }
36
37        tarjan(1, 0, visited, depth, ancestor, lca, adj, q, dsu);
38
39        int[] dist = new int[m];
40        int max = 0;
41
42        for (int i = 0; i < m; i++) {
43            int u = queries[i][0], v = queries[i][1];
44            dist[i] = depth[u] + depth[v] - 2 * depth[lca[i]];
45            max = Math.max(max, dist[i]);
46        }
47
48        int[] p = new int[max + 1];
49        if (max >= 1) {
50            p[1] = 1;
51        }
52
53        for (int i = 2; i <= max; i++) {
54            p[i] = (int) ((p[i - 1] * 2L) % MOD);
55        }
56
57        int[] ans = new int[m];
58        for (int i = 0; i < m; i++) {
59            ans[i] = p[dist[i]];
60        }
61
62        return ans;
63    }
64
65    private void tarjan(int node, int d, int[] visited, int[] depth, int[] ancestor,
66                        int[] lca, List<List<Integer>> adj, List<List<int[]>> q,
67                        DSU dsu) {
68        visited[node] = 1;
69        depth[node] = d;
70        ancestor[dsu.findParent(node)] = node;
71
72        for (int nei : adj.get(node)) {
73            if (visited[nei] == 0) {
74                tarjan(nei, d + 1, visited, depth, ancestor, lca, adj, q, dsu);
75                dsu.union(node, nei);
76                ancestor[dsu.findParent(node)] = node;
77            }
78        }
79
80        for (int[] query : q.get(node)) {
81            int nei = query[0], idx = query[1];
82            if (visited[nei] == 1) {
83                lca[idx] = ancestor[dsu.findParent(nei)];
84            }
85        }
86    }
87
88    class DSU {
89        int[] size, parent;
90        int componentCount;
91
92        public DSU(int n) {
93            size = new int[n];
94            parent = new int[n];
95            componentCount = n;
96            for (int i = 0; i < n; i++) {
97                size[i] = 1;
98                parent[i] = i;
99            }
100        }
101
102        public int findParent(int node) {
103            if (node == parent[node]) {
104                return node;
105            }
106            return parent[node] = findParent(parent[node]);
107        }
108
109        public boolean union(int u, int v) {
110            int pu = findParent(u), pv = findParent(v);
111            if (pu == pv) {
112                return false;
113            }
114            if (size[pu] < size[pv]) {
115                parent[pu] = pv;
116                size[pv] += size[pu];
117            } else {
118                parent[pv] = pu;
119                size[pu] += size[pv];
120            }
121            componentCount--;
122            return true;
123        }
124    }
125}