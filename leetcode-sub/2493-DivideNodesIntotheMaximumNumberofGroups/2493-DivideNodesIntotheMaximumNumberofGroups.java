// Last updated: 3/18/2026, 10:01:36 PM
1class Solution {
2    public int magnificentSets(int n, int[][] edges) {
3        DSU dsu = new DSU(n + 1);
4        List<List<Integer>> adj = new ArrayList<>();
5        for (int i = 0; i <= n; i++) {
6            adj.add(new ArrayList<>());
7        }
8        for (int[] edge : edges) {
9            int u = edge[0], v = edge[1];
10            adj.get(u).add(v);
11            adj.get(v).add(u);
12            dsu.union(u, v);
13        }
14        Map<Integer, Integer> map = new HashMap<>();
15        for (int i = 1; i <= n; i++) {
16            int max = bfs(adj, i, n);
17            if (max == -1) {
18                return -1;
19            }
20            int root = dsu.findParent(i);
21            map.put(root, Math.max(max, map.getOrDefault(root, 0)));
22        }
23        int sum = 0;
24        for (int count : map.values()) {
25            sum += count;
26        }
27        return sum;
28    }
29    private int bfs(List<List<Integer>> adj, int src, int n) {
30        Queue<Integer> queue = new LinkedList<>();
31        int[] visited = new int[n + 1];
32        Arrays.fill(visited, -1);
33        queue.offer(src);
34        visited[src] = 0;
35        int level = 0;
36        while (!queue.isEmpty()) {
37            int size = queue.size();
38            for (int i = 0; i < size; i++) {
39                int node = queue.poll();
40                for (int neighbor : adj.get(node)) {
41                    if (visited[neighbor] == -1) {
42                        visited[neighbor] = level + 1;
43                        queue.offer(neighbor);
44                    }
45                    else if (visited[neighbor] == level) {
46                        return -1;
47                    }
48                }
49            }
50            level++;
51        }
52        return level;
53    }
54    class DSU {
55        int[] size, parent;
56        int componentCount;
57        public DSU(int n) {
58            size = new int[n];
59            parent = new int[n];
60            componentCount = n;
61            for (int i = 0; i < n; i++) {
62                size[i] = 1;
63                parent[i] = i;
64            }
65        }
66
67        public int findParent(int node) {
68            if (node == parent[node]) {
69                return node;
70            }
71            return parent[node] = findParent(parent[node]);
72        }
73
74        public void union(int u, int v) {
75            int pu = findParent(u), pv = findParent(v);
76            if (pu == pv) return;
77
78            if (size[pu] < size[pv]) {
79                parent[pu] = pv;
80                size[pv] += size[pu];
81            } else {
82                parent[pv] = pu;
83                size[pu] += size[pv];
84            }
85            componentCount--;
86        }
87    }
88}