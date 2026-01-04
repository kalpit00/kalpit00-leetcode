// Last updated: 1/4/2026, 6:47:39 AM
1class Solution {
2    public int reachableNodes(int[][] edges, int maxMoves, int n) {
3        int[] costs = new int[n];
4        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
5        for (int i = 0; i < n; i++) {
6            costs[i] = Integer.MAX_VALUE;
7            adj.add(new ArrayList<>());
8        }
9        costs[0] = 0;
10        for (int[] edge : edges) {
11            int u = edge[0], v = edge[1], cnt = edge[2];
12            adj.get(u).add(new int[]{v, cnt + 1});
13            adj.get(v).add(new int[]{u, cnt + 1});
14        }
15        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
16        queue.offer(new int[]{0, 0});
17        while (!queue.isEmpty()) {
18            int[] info = queue.poll();
19            int node = info[0], cost = info[1];
20            if (cost > costs[node]) continue;
21            for (int[] neighbor : adj.get(node)) {
22                int nextNode = neighbor[0], weight = neighbor[1];
23                int newCost = cost + weight;
24                if (newCost < costs[nextNode]) {
25                    costs[nextNode] = newCost;
26                    queue.offer(new int[]{nextNode, newCost});
27                }
28            }
29        }
30        int count = 0;
31        for (int i = 0; i < n; i++) {
32            count += costs[i] <= maxMoves ? 1 : 0;
33        }
34        for (int[] edge : edges) {
35            int u = edge[0], v = edge[1], cnt = edge[2];
36            int reachableFromU = Math.max(0, maxMoves - costs[u]);
37            int reachableFromV = Math.max(0, maxMoves - costs[v]);
38            count += Math.min(cnt, reachableFromU + reachableFromV);
39        }
40        return count;
41    }
42}
43