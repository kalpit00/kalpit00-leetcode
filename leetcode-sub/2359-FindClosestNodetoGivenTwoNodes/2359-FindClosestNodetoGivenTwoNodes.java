// Last updated: 5/30/2025, 2:47:43 AM
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Integer[] dist1 = bfs(edges, node1), dist2 = bfs(edges, node2);
        int n = edges.length, min = Integer.MAX_VALUE, ans = -1;
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
    private Integer[] bfs(int[] edges, int src) {
        int n = edges.length;
        Integer[] dist = new Integer[n];
        Queue<Integer> queue = new LinkedList<>();
        dist[src] = 0;
        queue.offer(src);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            if (edges[parent] == -1) continue;
            int child = edges[parent];
            if (dist[child] == null) {
                dist[child] = dist[parent] + 1;
                queue.offer(child);
            }
        }
        return dist;
    }
}