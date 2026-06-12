// Last updated: 6/12/2026, 5:17:29 AM
1class Solution {
2    public int assignEdgeWeights(int[][] edges) {
3        int n = edges.length + 1, mod = 1000000007, count = 1;
4        List<List<Integer>> adj = new ArrayList<>(n + 1);
5        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
6        for (int[] edge : edges) {
7            int u = edge[0], v = edge[1];
8            adj.get(u).add(v);
9            adj.get(v).add(u);
10        }
11        int depth = dfs(1, 0, adj);
12        for (int i = 0; i < depth - 2; i++) {
13            count = (count * 2) % mod;
14        }
15        return count;
16    }
17    private int dfs(int node, int parent, List<List<Integer>> adj) {
18        int max = 0;
19        for (int child : adj.get(node)) {
20            if (child != parent) {
21                max = Math.max(max, dfs(child, node, adj));
22            }
23        }
24        return max + 1;
25    }
26}
27