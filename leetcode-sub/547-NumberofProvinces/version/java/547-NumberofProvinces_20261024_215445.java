// Last updated: 10/24/2026, 9:54:45 PM
1class Solution {
2    public int findCircleNum(int[][] isConnected) {
3        int n = isConnected.length;
4        DSU dsu = new DSU(n);
5        for (int i = 0; i < n; i++) {
6            for (int j = 0; j < n; j++) {
7                if (isConnected[i][j] == 1) {
8                    dsu.unionBySize(i, j);
9                }
10            }
11        }
12        return dsu.componentCount;
13    }
14    class DSU {
15        int[] parent, size;
16        int componentCount;
17        public DSU(int n) {
18            this.parent = new int[n];
19            this.size = new int[n];
20            componentCount = n;
21            for (int i = 0; i < n; i++) {
22                parent[i] = i;
23                size[i] = 1;
24            }
25        }
26        public int findParent(int node) {
27            if (node == parent[node]) {
28                return node;
29            }
30            return parent[node] = findParent(parent[node]);
31        }
32        public boolean unionBySize(int u, int v) {
33            int pu = findParent(u), pv = findParent(v);
34            if (pu == pv) {
35                return false;
36            }
37            if (size[pu] < size[pv]) {
38                parent[pu] = pv;
39                size[pv] += size[pu];
40            }
41            else {
42                parent[pv] = pu;
43                size[pu] += size[pv];
44            }
45            componentCount--;
46            return true;
47        }
48    }
49}