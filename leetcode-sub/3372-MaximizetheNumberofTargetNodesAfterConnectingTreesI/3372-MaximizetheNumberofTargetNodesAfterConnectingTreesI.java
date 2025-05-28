// Last updated: 5/28/2025, 1:15:55 AM
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1, m = edges2.length + 1, max = 0;
        int[] count1 = helper(edges1, k), count2 = helper(edges2, k - 1);
        for (int c : count2) {
            max = Math.max(max, c);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[i] + max;
        }
        return res;
    }

    private int[] helper(int[][] edges, int k) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = bfs(i, n, adj, k);
        }
        return res;
    }
    private int bfs(int src, int n, List<List<Integer>> adj, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(src);
        visited[src] = true;
        int count = 0, steps = 0;
        while (!queue.isEmpty() && steps <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                count++;
                int node = queue.poll();
                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
            steps++;
        }
        return count;
    }
}