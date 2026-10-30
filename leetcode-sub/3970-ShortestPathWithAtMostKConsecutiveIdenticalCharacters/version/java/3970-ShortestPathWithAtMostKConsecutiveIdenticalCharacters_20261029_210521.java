// Last updated: 10/29/2026, 9:05:21 PM
1
2class Solution {
3    public int shortestPath(int n, int[][] edges, String labels, int k) {
4        List<List<int[]>> adj = new ArrayList<>();
5        int m = edges.length;
6
7        for (int i = 0; i < n; i++) {
8            adj.add(new ArrayList<>());
9        }
10
11        for (int i = 0; i < m; i++) {
12            int u = edges[i][0], v = edges[i][1], wt = edges[i][2];
13            adj.get(u).add(new int[]{v, wt});
14        }
15
16        return dijkstra(adj, n, 0, labels, k);
17    }
18
19    private int dijkstra(List<List<int[]>> adj, int n, int src, String labels, int k) {
20        int[][] dist = new int[n][k + 1];
21        for (int i = 0; i < n; i++) {
22            Arrays.fill(dist[i], Integer.MAX_VALUE);
23        }
24
25        dist[src][1] = 0;
26
27        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
28        pq.offer(new Node(src, 0, labels.charAt(src), 1));
29
30        while (!pq.isEmpty()) {
31            Node parentNode = pq.poll();
32
33            int parent = parentNode.node, parentDist = parentNode.cost;
34            int parentCount = parentNode.count;
35            char parentChar = parentNode.c;
36
37            if (parentDist > dist[parent][parentCount]) {
38                continue;
39            }
40
41            for (int[] neighbor : adj.get(parent)) {
42                int child = neighbor[0], childDist = neighbor[1];
43
44                int childCount = labels.charAt(child) == parentChar
45                    ? parentCount + 1 : 1;
46
47                if (childCount > k) {
48                    continue;
49                }
50
51                int newDist = parentDist + childDist;
52
53                if (dist[child][childCount] > newDist) {
54                    dist[child][childCount] = newDist;
55                    pq.offer(new Node(child, newDist, labels.charAt(child), childCount));
56                }
57            }
58        }
59
60        int res = Integer.MAX_VALUE;
61        for (int i = 1; i <= k; i++) {
62            res = Math.min(res, dist[n - 1][i]);
63        }
64
65        return res == Integer.MAX_VALUE ? -1 : res;
66    }
67
68    class Node {
69        int node, cost, count;
70        char c;
71
72        public Node(int node, int cost, char c, int count) {
73            this.node = node;
74            this.cost = cost;
75            this.c = c;
76            this.count = count;
77        }
78    }
79}
80