// Last updated: 4/8/2026, 2:31:57 AM
1class Solution {
2    public int minimumVisitedCells(int[][] grid) {
3        int m = grid.length, n = grid[0].length, steps = 1;
4        DSU[] rows = new DSU[m], cols = new DSU[n];
5        for (int i = 0; i < m; i++) {
6            rows[i] = new DSU(n);
7        }
8        for (int j = 0; j < n; j++) {
9            cols[j] = new DSU(m);
10        }
11        boolean[][] visited = new boolean[m][n];
12        Queue<int[]> queue = new LinkedList<>();
13        queue.offer(new int[]{0, 0});
14        visited[0][0] = true;
15        while (!queue.isEmpty()) {
16            int size = queue.size();
17            for (int t = 0; t < size; t++) {
18                int[] node = queue.poll();
19                int i = node[0], j = node[1];
20                if (i == m - 1 && j == n - 1) {
21                    return steps;
22                }
23                if (grid[i][j] == 0) continue;
24                int r = Math.min(m - 1, i + grid[i][j]);
25                int c = Math.min(n - 1, j + grid[i][j]);
26                while (rows[i].findParent(j) < c) {
27                    int k = rows[i].findParent(j) + 1;
28                    rows[i].unionByParent(j, k);
29                    queue.offer(new int[]{i, k});
30                    visited[i][k] = true;
31                }
32                while (cols[j].findParent(i) < r) {
33                    int k = cols[j].findParent(i) + 1;
34                    cols[j].unionByParent(i, k);
35                    queue.offer(new int[]{k, j});
36                    visited[k][j] = true;
37                }                
38            }
39            steps++;
40        }
41        return -1;
42    }
43    public class DSU {
44        int[] parent;
45        int[] size;
46        public DSU (int n) {
47            parent = new int[n];
48            size = new int[n];
49            for (int i = 0; i < n; i++) {
50                parent[i] = i;
51                size[i] = 1;
52            }
53        }
54        public int findParent(int node) {
55            if (node == parent[node]) {
56                return node;
57            }
58            return parent[node] = findParent(parent[node]);
59        }
60        public boolean union(int u, int v) {
61            int pu = findParent(u), pv = findParent(v);
62            if (pu == pv) {
63                return false;
64            }
65            if (size[pu] < size[pv]) {
66                parent[pu] = pv;
67                size[pv] += size[pu];
68            }
69            else {
70                parent[pv] = pu;
71                size[pu] += size[pv];
72            }
73            return true;
74        }
75        public boolean unionByParent(int u, int v) {
76            int pu = findParent(u), pv = findParent(v);
77            if (pu == pv) {
78                return false;
79            } // just compare parent indices, not size or rank!
80            if (pu < pv) {
81                parent[pu] = pv;
82            }
83            else {
84                parent[pv] = pu;
85            }
86            return true;
87        }
88    }
89}