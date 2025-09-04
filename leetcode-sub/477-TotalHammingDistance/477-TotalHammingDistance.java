// Last updated: 9/4/2025, 1:45:38 PM
class Solution {
    public int minTime(int n, int[][] edges, int k) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[2], a[2]));
        DSU dsu = new DSU(n);
        int count = n;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], t = edge[2];
            count -= dsu.union(u, v) ? 1 : 0;
            if (count < k) {
                return t;
            }
        }
        return 0;
    }
    class DSU {
        int[] size, parent;
        int componentCount;
        public DSU(int n) {
            size = new int[n];
            parent = new int[n];
            componentCount = n;
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

        public boolean union(int u, int v) {
            int pu = findParent(u), pv = findParent(v);
            if (pu == pv) return false;
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            componentCount--;
            return true;
        }
    }
}