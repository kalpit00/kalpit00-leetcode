// Last updated: 1/26/2026, 9:15:08 PM
1class Solution {
2    public int minCost(int n, int[][] edges) {
3        List<List<int[]>> adj = new ArrayList<>();
4        for (int i = 0; i < n; i++) {
5            adj.add(new ArrayList<>());
6        }
7        for (int[] edge : edges) {
8            int u = edge[0], v = edge[1], wt = edge[2];
9            adj.get(u).add(new int[]{v, wt});
10            adj.get(v).add(new int[]{u, 2 * wt});
11        }
12        int[] dist = new int[n];
13        Arrays.fill(dist, Integer.MAX_VALUE);
14        dist[0] = 0;
15        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
16        pq.offer(new int[]{0, 0});
17        while (!pq.isEmpty()) {
18            int[] info = pq.poll();
19            int parent = info[0], parentDist = info[1];
20            // if (parentDist > dist[parent]) {
21            //     continue;
22            // }
23            for (int[] neighbor : adj.get(parent)) {
24                int child = neighbor[0], childDist = neighbor[1];
25                if (dist[child] > parentDist + childDist) {
26                    dist[child] = parentDist + childDist;
27                    pq.offer(new int[]{child, dist[child]});
28                }
29            }
30        }
31        return (dist[n - 1] == Integer.MAX_VALUE) ? -1 : dist[n - 1];
32    }
33}