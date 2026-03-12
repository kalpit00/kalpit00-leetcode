// Last updated: 3/11/2026, 9:12:47 PM
1class Solution {
2    public int maxStability(int n, int[][] edges, int k) {
3        DSU dsu = new DSU(n);
4        int min = Integer.MAX_VALUE;
5        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
6        List<Integer> list = new ArrayList<>();
7        for (int[] edge : edges) {
8            if (edge[3] == 0) {
9                pq.offer(edge);
10                continue;
11            }
12            if (!dsu.union(edge[0], edge[1])) {
13                return -1;
14            }
15            min = Math.min(min, edge[2]);
16        }
17        while (!pq.isEmpty() && dsu.componentCount > 1) {
18            int[] edge = pq.poll();
19            if (dsu.union(edge[0], edge[1])) {
20                list.add(edge[2]);
21            }
22        }
23        for (int i = list.size() - 1; i >= 0 && k > 0; i--) {
24            list.set(i, 2 * list.get(i));
25            k--;
26        }
27        for (int i : list) {
28            min = Math.min(min, i);
29        }
30        return dsu.componentCount != 1 ? -1 : min;
31    }
32    class DSU {
33        int[] size, parent;
34        int componentCount;
35
36        public DSU(int n) {
37            size = new int[n];
38            parent = new int[n];
39            componentCount = n;
40            for (int i = 0; i < n; i++) {
41                size[i] = 1;
42                parent[i] = i;
43            }
44        }
45
46        public int findParent(int node) {
47            if (node == parent[node]) {
48                return node;
49            }
50            return parent[node] = findParent(parent[node]);
51        }
52
53        public boolean union(int u, int v) {
54            int pu = findParent(u), pv = findParent(v);
55            if (pu == pv) {
56                return false;
57            }
58            if (size[pu] < size[pv]) {
59                parent[pu] = pv;
60                size[pv] += size[pu];
61            } else {
62                parent[pv] = pu;
63                size[pu] += size[pv];
64            }
65            componentCount--;
66            return true;
67        }
68    }
69}