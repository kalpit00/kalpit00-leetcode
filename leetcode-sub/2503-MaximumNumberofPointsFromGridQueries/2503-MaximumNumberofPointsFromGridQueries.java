// Last updated: 3/27/2025, 11:47:16 PM
class Solution {
    int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length, k = queries.length, idx = 0;
        int[] res = new int[k];
        DSU dsu = new DSU(m * n);
        int[][] sortedQueries = new int[k][2];
        for (int i = 0; i < k; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
        int[][] sortedCells = new int[m * n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sortedCells[i * n + j] = new int[]{i, j, grid[i][j]};
            }
        }
        Arrays.sort(sortedCells, (a, b) -> a[2] - b[2]);
        for (int[] query : sortedQueries) {
            int val = query[0], queryIdx = query[1];
            while (idx < m * n && sortedCells[idx][2] < val) {
                int x = sortedCells[idx][0], y = sortedCells[idx][1], 
                parent = x * n + y;
                for (int[] d : dir) {
                    int r = x + d[0], c = y + d[1], neighbor = r * n + c;
                    if (r >= 0 && r < m && c >= 0 && c < n &&
                    grid[r][c] < val) {
                        dsu.unionBySize(parent, neighbor);
                    }
                }
                idx++;
            }
            res[queryIdx] = val > grid[0][0] ? dsu.size[dsu.findParent(0)] : 0;
        }
        return res;
    }
    
    class DSU {
        int[] parent, size;
        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int findParent(int node) {
            if (node == parent[node]) return node;
            return parent[node] = findParent(parent[node]);
        }
        public void unionBySize(int u, int v) {
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
