// Last updated: 3/8/2026, 1:23:19 AM
1class Solution {
2    public int numberOfComponents(int[][] properties, int k) {
3        int n = properties.length, m = properties[0].length, count = 0;
4        DSU dsu = new DSU(n);
5        Map<Integer, Set<Integer>> map = new HashMap<>();
6        for (int i = 0; i < n; i++) {
7            map.putIfAbsent(i, new HashSet<>());            
8            for (int j = 0; j < m; j++) {
9                map.get(i).add(properties[i][j]);
10            }
11        }
12        for (int i = 0; i < n; i++) {
13            for (int j = i + 1; j < n; j++) {
14                if (helper(map, k, i, j)) {
15                    count += dsu.union(i, j) ? 1 : 0;
16                }
17            }
18        }
19        return n - count;
20    }
21    private boolean helper(Map<Integer, Set<Integer>> map, int k, 
22    int i, int j) {
23        for (Integer key : map.get(i)) {
24            k -= map.get(j).contains(key) ? 1 : 0;
25            if (k <= 0) {
26                return true;
27            }
28        }
29        return k <= 0;
30    }
31    public class DSU {
32        int[] parent;
33        int[] size;
34        public DSU (int n) {
35            parent = new int[n];
36            size = new int[n];
37            for (int i = 0; i < n; i++) {
38                parent[i] = i;
39                size[i] = 1;
40            }
41        }
42        public int findParent(int node) {
43            if (node == parent[node]) {
44                return node;
45            }
46            return parent[node] = findParent(parent[node]);
47        }
48        public boolean union(int u, int v) {
49            int pu = findParent(u), pv = findParent(v);
50            if (pu == pv) {
51                return false;
52            }
53            if (size[pu] < size[pv]) {
54                parent[pu] = pv;
55                size[pv] += size[pu];
56            }
57            else {
58                parent[pv] = pu;
59                size[pu] += size[pv];
60            }
61            return true;
62        }
63    }
64}