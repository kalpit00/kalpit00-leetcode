// Last updated: 10/7/2025, 12:33:17 AM
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        DSU dsu = new DSU(n + 1);
        int[] res = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                res[i] = 1;
                continue;
            }
            Integer j = map.get(lake);
            if (j != null) {
                int dry = dsu.findParent(j + 1);
                if (dry >= i) {
                    return new int[0];
                }
                res[dry] = lake;
                dsu.parent[dry] = dsu.findParent(dry + 1);
            }
            res[i] = -1;
            dsu.parent[i] = i + 1;
            map.put(lake, i);
        }
        return res;
    }
    public class DSU {
        int[] parent;
        int[] size;
        public DSU (int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
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
            if (pu == pv) {
                return false;
            }
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
            else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            return true;
        }
    }
}