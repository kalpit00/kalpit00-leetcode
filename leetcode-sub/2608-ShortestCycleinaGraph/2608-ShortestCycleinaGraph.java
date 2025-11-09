// Last updated: 11/8/2025, 10:59:57 PM
class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int minCycle = Integer.MAX_VALUE;
        
        // Try BFS from each node to find shortest cycle containing that node
        for (int start = 0; start < n; start++) {
            int cycle = bfs(start, adj, n);
            minCycle = Math.min(minCycle, cycle);
        }
        
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
    
    private int bfs(int start, List<List<Integer>> adj, int n) {
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, -1);
        Arrays.fill(parent, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;
        
        int minCycle = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) {
                    // Unvisited node
                    dist[neighbor] = dist[node] + 1;
                    parent[neighbor] = node;
                    queue.offer(neighbor);
                } 
                else if (parent[node] != neighbor) {
                    // Found a cycle: neighbor is visited and not the parent
                    // Cycle length = dist[node] + dist[neighbor] + 1
                    int cycleLength = dist[node] + dist[neighbor] + 1;
                    minCycle = Math.min(minCycle, cycleLength);
                }
            }
        }
        
        return minCycle;
    }
}
