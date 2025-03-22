// Last updated: 3/22/2025, 6:01:43 AM
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] map = new int[n];
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            dsu.unionBySize(edge[0], edge[1]);
        }
        for (int[] edge : edges) {
            map[dsu.findParent(edge[0])]++;
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int root = dsu.findParent(i);
            if (!visited[root]) {
                visited[root] = true;
                int vertices = dsu.size[root], edgeCount = map[root];
                if (edgeCount == vertices * (vertices - 1) / 2) {
                    count++;
                }
            }
        }
        return count;
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
