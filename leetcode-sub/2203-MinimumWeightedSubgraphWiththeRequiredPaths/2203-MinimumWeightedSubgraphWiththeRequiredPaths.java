// Last updated: 5/29/2025, 10:32:42 PM
class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<int[]>> adj = new ArrayList<>();
        List<List<int[]>> revAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            revAdj.get(v).add(new int[]{u, wt});
        }
        long[] dist1 = bfs(n, adj, src1), dist2 = bfs(n, adj, src2),
        dist3 = bfs(n, revAdj, dest);
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist1[i] == Long.MAX_VALUE || dist2[i] == Long.MAX_VALUE 
            || dist3[i] == Long.MAX_VALUE) {
                continue;
            }
            min = Math.min(min, dist1[i] + dist2[i] + dist3[i]);
        }
        return min == Long.MAX_VALUE ? -1 : min;
    }
    private long[] bfs(int n, List<List<int[]>> adj, int src) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        dist[src] = 0;
        pq.offer(new long[]{src, 0});
        while (!pq.isEmpty()) {
            long[] item = pq.poll();
            int parent = (int) item[0];
            long parentDist = item[1];
            if (parentDist > dist[parent]) continue;
            for (int[] neighbor : adj.get(parent)) {
                int child = neighbor[0];
                long wt = neighbor[1];
                if (dist[child] > dist[parent] + wt) {
                    dist[child] = dist[parent] + wt;
                    pq.offer(new long[]{child, dist[child]});
                }
            }
        }
        return dist;
    }
}