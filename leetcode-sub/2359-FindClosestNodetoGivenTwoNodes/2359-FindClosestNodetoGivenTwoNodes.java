// Last updated: 5/30/2025, 2:44:33 AM
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
        Integer[] dist1 = bfs(n, adj, node1), dist2 = bfs(n, adj, node2);
        int min = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] == null || dist2[i] == null) {
                continue;
            }
            if (min > Math.max(dist1[i], dist2[i])) {
                min = Math.max(dist1[i], dist2[i]);
                ans = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : ans;
    }
    private Integer[] bfs(int n, List<List<int[]>> adj, int src) {
        Integer[] dist = new Integer[n];
        Queue<Integer> queue = new LinkedList<>();
        dist[src] = 0;
        queue.offer(src);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int[] neighbor : adj.get(parent)) {
                int child = neighbor[0], wt = neighbor[1]; // wt = 1
                if (dist[child] == null) {
                    dist[child] = dist[parent] + wt;
                    queue.offer(child);
                }
            }
        }
        return dist;
    }
}