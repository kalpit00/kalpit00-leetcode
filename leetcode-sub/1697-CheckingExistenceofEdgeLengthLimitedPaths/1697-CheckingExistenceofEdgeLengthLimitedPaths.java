// Last updated: 4/13/2025, 5:36:21 PM
class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edges, int[][] queries) {
        DSU dsu = new DSU(n);
        int m = queries.length;
        boolean[] res = new boolean[m];
        int[][] grid = new int[m][4];
        for (int i = 0; i < m; i++) {
            grid[i][0] = queries[i][0];
            grid[i][1] = queries[i][1];
            grid[i][2] = queries[i][2];
            grid[i][3] = i;
        }
        Arrays.sort(grid, (a, b) -> a[2] - b[2]);
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int j = 0;
        for (int i = 0; i < m; i++) {
            int u = grid[i][0], v = grid[i][1], limit = grid[i][2], 
            idx = grid[i][3];
            while (j < edges.length && edges[j][2] < limit) {
                dsu.union(edges[j][0], edges[j][1]);
                j++;
            }
            res[idx] = dsu.findParent(u) == dsu.findParent(v);
        }
        return res;
    }
    class DSU {
        int[] size, parent;
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

        public void union(int u, int v) {
            int pu = findParent(u), pv = findParent(v);
            if (pu == pv) return;
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }
}