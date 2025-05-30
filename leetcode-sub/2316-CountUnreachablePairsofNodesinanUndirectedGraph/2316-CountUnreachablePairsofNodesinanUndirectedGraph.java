// Last updated: 5/30/2025, 2:44:23 PM
class Solution {
    public int[] timeTaken(int[][] edges) {
        int n = edges.length + 1;
        int[] ans = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int dist[] = bfs(n, adj, 0), max = getMax(dist);
        int dist1[] = bfs(n, adj, max), secondMax = getMax(dist1);
        int dist2[] = bfs(n, adj, secondMax);
        for (int i = 0; i < n; i++) {
            ans[i] = Math.max(dist1[i], dist2[i]) - (2 - (i % 2));
        }
        return ans;
    }

    private int[] bfs(int n, List<List<Integer>> adj, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MIN_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        dist[src] = (src % 2 == 1) ? 1 : 2;
        queue.offer(src);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u : adj.get(v)) {
                if (dist[u] != Integer.MIN_VALUE) continue;
                int wt = ((u % 2 == 1) ? 1 : 2);
                dist[u] = dist[v] + wt;
                queue.offer(u);
            }
        }
        return dist;
    }
    private int getMax(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE, ans = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ans = i;
            }
        }
        return ans;
    }
}
