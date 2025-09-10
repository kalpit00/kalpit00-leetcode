// Last updated: 9/9/2025, 8:03:48 PM
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU dsu = new DSU(n);
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i][0] - arr[i - 1][0] <= maxDiff) {
                dsu.union(arr[i][1], arr[i - 1][1]);
            }
        }
        int m = queries.length;
        boolean[] res = new boolean[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0], v = queries[i][1];
            res[i] = dsu.findParent(u) == dsu.findParent(v);
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