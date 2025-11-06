// Last updated: 11/5/2025, 8:25:08 PM
class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c + 1);
        boolean[] visited = new boolean[c + 1];
        int count = 0, idx = 0;
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            dsu.union(u, v);
        }
        for (int i = 1; i <= c; i++) {
            int parent = dsu.findParent(i);
            map.putIfAbsent(parent, new TreeSet<>());
            map.get(parent).add(i);
        }
        for (int[] q : queries) {
            count += q[0] == 1 ? 1 : 0;
        }
        int[] res = new int[count];
        for (int[] q : queries) {
            int i = q[1];
            if (q[0] == 2) {
                visited[i] = true;
                map.get(dsu.findParent(i)).remove(i);
            }
            else {
                if (!visited[i]) {
                    res[idx++] = i;
                }
                else {
                    int parent = dsu.findParent(i);
                    if (!map.containsKey(parent) || map.get(parent).isEmpty()) {
                        res[idx++] = -1;
                    }
                    else {
                        res[idx++] = map.get(parent).iterator().next();
                    }
                }
            }
        }
        return res;
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
            componentCount--;
        }
    }
}