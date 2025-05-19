// Last updated: 5/19/2025, 1:00:37 AM
class Solution {
    public long maximizeSumOfWeights(int[][] edges, int k) {
        int n = edges.length + 1;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        return dfs(0, -1, k, adj)[0];
    }

    private long[] dfs(int u, int parent, int k, List<List<int[]>> adj) {
        long sum = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int[] nei : adj.get(u)) {
            int v = nei[0], wt = nei[1];
            if (v == parent) continue;
            long[] next = dfs(v, u, k, adj);
            next[1] += wt;
            sum += Math.max(next[0], next[1]);
            if (next[1] > next[0]) {
                queue.offer(next[1] - next[0]);
                if (queue.size() > k) {
                    sum -= queue.poll();
                }
            }
        }
        return new long[]{sum, sum - (queue.size() < k ? 0 : queue.peek())};
    }
}
