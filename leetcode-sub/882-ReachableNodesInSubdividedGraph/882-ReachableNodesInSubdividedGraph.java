// Last updated: 1/4/2026, 6:49:53 AM
1class Solution {
2    public int reachableNodes(int[][] edges, int maxMoves, int n) {
3        int[] dist = new int[n];
4        List<List<int[]>> adj  = new ArrayList<>();
5        for (int i = 0; i < n; i++) {
6            dist[i] = Integer.MAX_VALUE;
7            adj.add(new ArrayList<>());
8        }
9        dist[0] = 0;
10        for (int[] edge : edges) {
11            int u = edge[0], v = edge[1], w = edge[2];
12            adj.get(u).add(new int[]{v, w + 1});
13            adj.get(v).add(new int[]{u, w + 1});
14        }
15        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
16        queue.offer(new int[]{0, 0});
17        while (!queue.isEmpty()) {
18            int[] info = queue.poll();
19            int parent = info[0], d = info[1];
20            if (d > dist[parent]) continue;
21            for (int[] neighbor : adj.get(parent)) {
22                int child = neighbor[0], weight = neighbor[1];
23                if (dist[child] > dist[parent] + weight) {
24                    dist[child] = dist[parent] + weight;
25                    queue.offer(new int[] {child, dist[child]});
26                }
27            }
28        }
29        int count = 0;
30        for (int i = 0; i < n; i++) {
31            count += dist[i] <= maxMoves ? 1 : 0;
32        }
33        for (int[] edge : edges) {
34            int u = edge[0], v = edge[1], w = edge[2];
35            int reachableFromU = Math.max(0, maxMoves - dist[u]);
36            int reachableFromV = Math.max(0, maxMoves - dist[v]);
37            count += Math.min(w, reachableFromU + reachableFromV);
38        }
39        return count;
40    }
41}