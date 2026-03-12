// Last updated: 3/12/2026, 2:03:05 AM
1class Solution {
2    public int maxStability(int n, int[][] edges, int k) {
3        DSU dsu = new DSU(n);
4        int min = Integer.MAX_VALUE;
5        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
6        List<Integer> list = new ArrayList<>();
7        for (int[] edge : edges) {
8            if (edge[3] == 0) { // offer all 0-edges in maxHeap
9                pq.offer(edge);
10            }
11            else { // union all 1-edges as must!
12                if (!dsu.union(edge[0], edge[1])) {
13                    return -1;
14                }
15                min = Math.min(min, edge[2]);                
16            }
17        } // MST pruning in while loop is 2x faster
18        while (!pq.isEmpty() && dsu.componentCount > 1) {
19            int[] edge = pq.poll();
20            if (dsu.union(edge[0], edge[1])) {
21                list.add(edge[2]);
22            } // union the largest 0-edges until MST formed!
23        }
24        for (int i = list.size() - 1; i >= 0; i--) {
25            if (k > 0) {
26                list.set(i, 2 * list.get(i));
27                k--;
28            }
29            min = Math.min(min, list.get(i));
30        } // of those who made the MST, double the 'k' smallest ones
31        return dsu.componentCount != 1 ? -1 : min;
32    }
33    class DSU {
34        int[] size, parent;
35        int componentCount;
36
37        public DSU(int n) {
38            size = new int[n];
39            parent = new int[n];
40            componentCount = n;
41            for (int i = 0; i < n; i++) {
42                size[i] = 1;
43                parent[i] = i;
44            }
45        }
46
47        public int findParent(int node) {
48            if (node == parent[node]) {
49                return node;
50            }
51            return parent[node] = findParent(parent[node]);
52        }
53
54        public boolean union(int u, int v) {
55            int pu = findParent(u), pv = findParent(v);
56            if (pu == pv) {
57                return false;
58            }
59            if (size[pu] < size[pv]) {
60                parent[pu] = pv;
61                size[pv] += size[pu];
62            } else {
63                parent[pv] = pu;
64                size[pu] += size[pv];
65            }
66            componentCount--;
67            return true;
68        }
69    }
70}