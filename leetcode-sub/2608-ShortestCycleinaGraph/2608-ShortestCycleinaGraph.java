// Last updated: 11/18/2025, 1:02:38 AM
class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(min, bfs(i, adj, n));
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int bfs(int start, List<List<Integer>> adj, int n) {
        int[] dist = new int[n], parent = new int[n];
        Arrays.fill(dist, -1);
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) { // unvisited
                    dist[neighbor] = dist[node] + 1;
                    parent[neighbor] = node;
                    queue.offer(neighbor);
                } 
                else if (parent[node] != neighbor) {
                    min = Math.min(min, dist[node] + dist[neighbor] + 1);
                } // Found a cycle: neighbor is visited and not the parent
            }
        }
        return min;
    }
}
