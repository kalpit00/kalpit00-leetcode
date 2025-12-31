// Last updated: 12/31/2025, 2:26:09 AM
1class Solution {
2    public int latestDayToCross(int m, int n, int[][] cells) {
3        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
4        int k = m * n, top = k, bottom = k + 1;        
5        DSU dsu = new DSU(k + 2); // use 2 sentinels [k, k+1] for top & bottom
6        boolean[][] visited = new boolean[m][n];
7        for (int i = cells.length - 1; i >= 0; i--) {
8            int x = cells[i][0] - 1, y = cells[i][1] - 1; // 1-indexed so -1
9            int idx = x * n + y; // 2D -> 1D indexing
10            visited[x][y] = true;
11            for (int[] dir : dirs) {
12                int r = x + dir[0], c = y + dir[1];
13                if (r >= 0 && r < m && c >= 0 && c < n 
14                && visited[r][c]) {
15                    int neighborIdx = r * n + c;
16                    dsu.unionBySize(idx, neighborIdx);
17                }
18            } // connect cell on first row 0 with TOP sentinel
19            if (x == 0) {
20                dsu.unionBySize(idx, top);                
21            } // connect cell on last row : m - 1 with BOTTOM sentinel
22            if (x == m - 1) {
23                dsu.unionBySize(idx, bottom);                
24            }
25            if (dsu.findParent(top) == dsu.findParent(bottom)) {
26                return i;
27            } // if top and bottom are connected, this is the last day
28        } // as we go from right to left, rightmost day is greedily the last day
29        return 0;
30    }
31    class DSU {
32        int[] rank, size, parent;
33
34        public DSU(int n) {
35            rank = new int[n];
36            size = new int[n];
37            parent = new int[n];
38            for (int i = 0; i < n; i++) {
39                size[i] = 1;
40                parent[i] = i;
41            }
42        }
43
44        public int findParent(int node) {
45            if (node == parent[node]) {
46                return node;
47            }
48            return parent[node] = findParent(parent[node]);
49        }
50
51        public void unionBySize(int u, int v) {
52            int pu = findParent(u), pv = findParent(v);
53            if (pu == pv) return;
54
55            if (size[pu] < size[pv]) {
56                parent[pu] = pv;
57                size[pv] += size[pu];
58            } else {
59                parent[pv] = pu;
60                size[pu] += size[pv];
61            }
62        }
63    }
64}