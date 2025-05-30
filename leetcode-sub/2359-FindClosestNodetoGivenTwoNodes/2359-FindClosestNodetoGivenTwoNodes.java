// Last updated: 5/29/2025, 10:49:45 PM
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (edges[i] == -1) continue;
            int u = i, v = edges[i], wt = 1;
            adj.get(u).add(new int[]{v, wt});
        }
        int[] dist1 = bfs(n, adj, node1), dist2 = bfs(n, adj, node2);
        int min = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE){
                continue;
            }
            if (min > Math.max(dist1[i], dist2[i])) {
                min = Math.max(dist1[i], dist2[i]);
                ans = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : ans;
    }
    private int[] bfs(int n, List<List<int[]>> adj, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        dist[src] = 0;
        queue.offer(src);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int[] neighbor : adj.get(parent)) {
                int child = neighbor[0], wt = neighbor[1]; // wt = 1
                if (dist[child] > dist[parent] + wt) {
                    dist[child] = dist[parent] + wt;
                    queue.offer(child);
                }
            }
        }
        return dist;
    }
}