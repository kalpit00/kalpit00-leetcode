// Last updated: 3/22/2025, 5:58:10 AM
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] edgeCount = new int[n];
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            dsu.unionBySize(u, v);
            int root = dsu.findParent(u);
            edgeCount[root]++;
        }
        int ans = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int root = dsu.findParent(i);
            if (!visited[root]) {
                visited[root] = true;
                int vertices = dsu.size[root];
                int m = edgeCount[root];
                if (m == vertices * (vertices - 1) / 2) {
                    ans++;
                }
            }
        }
        
        return ans;
    }

    public class DSU {
        int[] size;
        int[] parent;
        
        public DSU(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
        
        public int findParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
        
        public void unionBySize(int u, int v) {
            int pu = findParent(u), pv = findParent(v);
            if (pu == pv) {
                return;
            }
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
            else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }
}
