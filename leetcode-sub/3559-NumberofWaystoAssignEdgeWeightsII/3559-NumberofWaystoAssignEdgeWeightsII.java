// Last updated: 6/12/2026, 5:59:33 AM
1class Solution { // offline tarjan + unionFind
2    int mod = 1000000007;
3    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
4        int n = edges.length + 1, m = queries.length, max = 0;
5        List<List<Integer>> adj = new ArrayList<>();
6        List<List<int[]>> q = new ArrayList<>();
7        int[] parent = new int[n + 1], visited = new int[n + 1], 
8        depth = new int[n + 1], lca = new int[m], ans = new int[m];
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
23        } // calling it tarjan() but its really a modified dfs()
24        tarjan(1, 0, parent, visited, depth, lca, adj, q);
25        for (int i = 0; i < m; i++) {
26            int u = queries[i][0], v = queries[i][1];
27            int d = depth[u] + depth[v] - 2 * depth[lca[i]];
28            ans[i] = d == 0 ? 0 : modPow(2, d - 1);
29        } // 2^(d - 1), where d = shortest path length between u - v 
30        return ans;
31    }
32    private void tarjan(int node, int d, int[] parent, int[] visited,
33    int[] depth, int[] lca, List<List<Integer>> adj, List<List<int[]>> q) {
34        visited[node] = 1;
35        depth[node] = d;
36        for (int neighbor : adj.get(node)) {
37            if (visited[neighbor] == 0) {
38                tarjan(neighbor, d + 1, parent, visited, depth, lca, adj, q);
39                parent[neighbor] = node;
40            }
41        }
42        for (int[] query : q.get(node)) {
43            int v = query[0], idx = query[1];
44            if (visited[v] == 1) {
45                lca[idx] = findParent(v, parent);
46            }
47        }
48    } // naive direct union find
49    private int findParent(int node, int[] parent) {
50        if (node == parent[node]) {
51            return node;
52        }
53        return parent[node] = findParent(parent[node], parent);
54    } // 2^x in logN
55    private int modPow(int base, int exp) {
56        long res = 1, b = base;
57        while (exp > 0) {
58            if ((exp & 1) == 1) res = res * b % mod;
59            b = b * b % mod;
60            exp >>= 1;
61        }
62        return (int) res;
63    }
64}