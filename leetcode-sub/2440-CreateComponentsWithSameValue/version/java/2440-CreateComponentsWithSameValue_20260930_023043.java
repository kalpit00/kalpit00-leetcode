// Last updated: 9/30/2026, 2:30:43 AM
1class Solution {
2    public int maxActivated(int[][] points) {
3        int n = points.length, max = 0, secondMax = 0;
4        DSU dsu = new DSU(n);
5        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
6        for (int i = 0; i < n; i++) {
7            int x = points[i][0], y = points[i][1];
8            if (map1.containsKey(x)) dsu.union(i, map1.get(x));
9            else map1.put(x, i);
10            if (map2.containsKey(y)) dsu.union(i, map2.get(y));
11            else map2.put(y, i);
12        }
13        for (int i = 0; i < n; i++) {
14            if (dsu.findParent(i) == i) {
15                if (dsu.size[i] > max) {
16                    secondMax = max;
17                    max = dsu.size[i];
18                } else if (dsu.size[i] > secondMax) {
19                    secondMax = dsu.size[i];
20                }
21            }
22        }
23        return max + secondMax + 1;
24    }
25    class DSU {
26        int[] rank, size, parent;
27
28        public DSU(int n) {
29            rank = new int[n];
30            size = new int[n];
31            parent = new int[n];
32            for (int i = 0; i < n; i++) {
33                size[i] = 1;
34                parent[i] = i;
35            }
36        }
37
38        public int findParent(int node) {
39            if (node == parent[node]) {
40                return node;
41            }
42            return parent[node] = findParent(parent[node]);
43        }
44
45        public boolean union(int u, int v) {
46            int pu = findParent(u), pv = findParent(v);
47            if (pu == pv) return true;
48
49            if (size[pu] < size[pv]) {
50                parent[pu] = pv;
51                size[pv] += size[pu];
52            } else {
53                parent[pv] = pu;
54                size[pu] += size[pv];
55            }
56            return false;
57        }
58    }
59}