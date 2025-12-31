// Last updated: 12/31/2025, 2:21:06 AM
1class Solution {
2    public int latestDayToCross(int row, int col, int[][] cells) {
3        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
4        int n = row * col, top = n, bottom = n + 1;        
5        DSU dsu = new DSU(n + 2);
6        boolean[][] visited = new boolean[row][col];
7        for (int i = cells.length - 1; i >= 0; i--) {
8            int x = cells[i][0] - 1, y = cells[i][1] - 1; // 1-indexed so -1
9            int idx = x * col + y; // 2D -> 1D indexing
10            visited[x][y] = true;
11            for (int[] dir : dirs) {
12                int r = x + dir[0], c = y + dir[1];
13                if (r >= 0 && r < row && c >= 0 && c < col 
14                && visited[r][c]) {
15                    int neighborIdx = r * col + c;
16                    dsu.unionBySize(idx, neighborIdx);
17                }
18            }
19            if (x == 0) {
20                dsu.unionBySize(idx, top);                
21            }
22            if (x == row - 1) {
23                dsu.unionBySize(idx, bottom);                
24            }
25            if (dsu.findParent(top) == dsu.findParent(bottom)) {
26                return i;
27            }
28        }
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