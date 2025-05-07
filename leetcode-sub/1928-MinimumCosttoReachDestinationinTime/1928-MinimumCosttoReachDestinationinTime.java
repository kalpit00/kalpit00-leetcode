// Last updated: 5/6/2025, 10:05:26 PM
class Solution {
    public int minCost(int maxTime, int[][] edges, int[] cost) {
        int n = cost.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, cost[0], 0}); // <node, cost, time>
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int parent = node[0], parentCost = node[1], parentTime = node[2];
            if (parentTime >= dist[parent] || parentTime > maxTime) {
                continue;
            }
            if (parent == n - 1) {
                return parentCost;
            }
            dist[parent] = parentTime;
            for (int[] neighbor : adj.get(parent)) {
                int child = neighbor[0], childTime = parentTime + neighbor[1], 
                childCost = parentCost + cost[child];
                pq.offer(new int[]{child, childCost, childTime});
            }
        }
        return -1;
    }
}