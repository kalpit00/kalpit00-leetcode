// Last updated: 6/12/2026, 5:48:10 AM
1class Solution { // offline tarjan + unionFind
2    int mod = 1000000007;
3    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
4        int n = edges.length + 1, m = queries.length, max = 0;
5        List<List<Integer>> adj = new ArrayList<>();
6        List<List<int[]>> q = new ArrayList<>();
7        int[] parent = new int[n + 1], visited = new int[n + 1], 
8        depth = new int[n + 1], lca = new int[m], dist = new int[m];
9        for (int i = 0; i <= n; i++) {
10            parent[i] = i;            
11            adj.add(new ArrayList<>());
12            q.add(new ArrayList<>());
13        }
14        for (int[] edge : edges) {
15            int u = edge[0], v = edge[1];
16            adj.get(u).add(v);
17            adj.get(v).add(u);
18        }
19        for (int i = 0; i < m; i++) {
20            int u = queries[i][0], v = queries[i][1];
21            q.get(u).add(new int[]{v, i});
22            q.get(v).add(new int[]{u, i});
23        } // calling it tarjan() but its really a modified dfs
24        tarjan(1, 0, parent, visited, depth, lca, adj, q);
25        for (int i = 0; i < m; i++) {
26            int u = queries[i][0], v = queries[i][1];
27            dist[i] = depth[u] + depth[v] - 2 * depth[lca[i]];
28            max = Math.max(max, dist[i]);
29        } // p[i] = 2^i, with mod
30        int[] p = new int[max + 1], ans = new int[m];
31        p[1] = max >= 1 ? 1 : 0;
32        for (int i = 2; i <= max; i++) {
33            p[i] = (p[i - 1] * 2 % mod);
34        }
35        for (int i = 0; i < m; i++) {
36            ans[i] = p[dist[i]];
37        }
38        return ans;
39    }
40    private void tarjan(int node, int d, int[] parent, int[] visited,
41    int[] depth, int[] lca, List<List<Integer>> adj, List<List<int[]>> q) {
42        visited[node] = 1;
43        depth[node] = d;
44        for (int neighbor : adj.get(node)) {
45            if (visited[neighbor] == 0) {
46                tarjan(neighbor, d + 1, parent, visited, depth, lca, adj, q);
47                parent[neighbor] = node;
48            }
49        }
50        for (int[] query : q.get(node)) {
51            int dest = query[0], idx = query[1];
52            if (visited[dest] == 1) {
53                lca[idx] = findParent(dest, parent);
54            }
55        }
56    } // naive direct union find
57    private int findParent(int node, int[] parent) {
58        if (node == parent[node]) {
59            return node;
60        }
61        return parent[node] = findParent(parent[node], parent);
62    }
63}