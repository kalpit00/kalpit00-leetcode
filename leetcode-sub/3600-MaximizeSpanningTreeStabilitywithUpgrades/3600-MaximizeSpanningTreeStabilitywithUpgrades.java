// Last updated: 3/11/2026, 9:11:42 PM
1class Solution {
2    public int maxStability(int n, int[][] edges, int k) {
3        DSU dsu = new DSU(n);
4        int min = Integer.MAX_VALUE, count = 0;
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
15            count++;
16            min = Math.min(min, edge[2]);
17        }
18        while (!pq.isEmpty() && dsu.componentCount > 1) {
19            int[] edge = pq.poll();
20            if (dsu.union(edge[0], edge[1])) {
21                count++;
22                list.add(edge[2]);
23            }
24        }
25        for (int i = list.size() - 1; i >= 0 && k > 0; i--) {
26            list.set(i, 2 * list.get(i));
27            k--;
28        }
29        for (int i : list) {
30            min = Math.min(min, i);
31        }
32        return count != n - 1 ? -1 : min;
33    }
34    class DSU {
35        int[] size, parent;
36        int componentCount;
37
38        public DSU(int n) {
39            size = new int[n];
40            parent = new int[n];
41            componentCount = n;
42            for (int i = 0; i < n; i++) {
43                size[i] = 1;
44                parent[i] = i;
45            }
46        }
47
48        public int findParent(int node) {
49            if (node == parent[node]) {
50                return node;
51            }
52            return parent[node] = findParent(parent[node]);
53        }
54
55        public boolean union(int u, int v) {
56            int pu = findParent(u), pv = findParent(v);
57            if (pu == pv) {
58                return false;
59            }
60            if (size[pu] < size[pv]) {
61                parent[pu] = pv;
62                size[pv] += size[pu];
63            } else {
64                parent[pv] = pu;
65                size[pu] += size[pv];
66            }
67            componentCount--;
68            return true;
69        }
70    }
71}