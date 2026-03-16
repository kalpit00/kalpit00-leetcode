// Last updated: 3/16/2026, 7:47:08 PM
1class Solution {
2    public int[] findRedundantDirectedConnection(int[][] edges) {
3        int n = edges.length, node = -1;
4        int[] indegree = new int[n + 1];
5        for (int[] edge : edges) {
6            int u = edge[0], v = edge[1];
7            indegree[v]++;
8            if (indegree[v] == 2) {
9                node = v; // there's only one node with 2 incoming edges
10                break; // as there are 'n' edges and 'n' nodes!
11            }
12        } // if no such node found, its same as #684
13        if (node == -1) {
14            return findRedundantConnection(edges, new int[]{-1, -1});
15        } // else, try to find the last edge that is redundant!
16        for (int i = n - 1; i >= 0; i--) {
17            int[] edge = edges[i];
18            int u = edge[0], v = edge[1];
19            if (v == node) {
20                int[] ans = findRedundantConnection(edges, edge);
21                if (ans == null) {
22                    return edge;
23                }
24            }
25        }
26        return new int[]{};
27    }
28    public int[] findRedundantConnection(int[][] edges, int[] skip) {
29        int n = edges.length;
30        DSU dsu = new DSU(n + 1);
31        for (int[] edge : edges) {
32            int u = edge[0], v = edge[1];
33            if (u == skip[0] && v == skip[1]) continue;
34            if (!dsu.union(u, v)) {
35                return new int[]{u, v};
36            }
37        }
38        return null;
39    }
40    public class DSU {
41        int[] parent;
42        int[] size;
43        public DSU (int n) {
44            parent = new int[n];
45            size = new int[n];
46            for (int i = 0; i < n; i++) {
47                parent[i] = i;
48                size[i] = 1;
49            }
50        }
51        public int findParent(int node) {
52            if (node == parent[node]) {
53                return node;
54            }
55            return parent[node] = findParent(parent[node]);
56        }
57        public boolean union(int u, int v) {
58            int pu = findParent(u), pv = findParent(v);
59            if (pu == pv) {
60                return false;
61            }
62            if (size[pu] < size[pv]) {
63                parent[pu] = pv;
64                size[pv] += size[pu];
65            }
66            else {
67                parent[pv] = pu;
68                size[pu] += size[pv];
69            }
70            return true;
71        }
72    }
73}