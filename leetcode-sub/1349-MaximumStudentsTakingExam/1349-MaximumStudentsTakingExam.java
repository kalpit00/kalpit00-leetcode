// Last updated: 6/18/2025, 1:46:41 AM
class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length, count = 0;
        List<List<Edge>> adj = buildFlowNetwork(seats, m, n);
        int source = m * n, sink = m * n + 1, size = m * n + 2; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += seats[i][j] == '.' ? 1 : 0;
            }
        } // Max Independent Set = Total count of Seats - MaxFlow
        int maxFlow = dinics(source, sink, adj, size);
        return count - maxFlow;
    }
    
    private List<List<Edge>> buildFlowNetwork(char[][] seats, int m, int n) {
        int source = m * n, sink = m * n + 1, size = m * n + 2; 
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < size; i++) { // m * n nodes, +2 for source and sink
            adj.add(new ArrayList<>());
        }// 6 dir : left, right, top-left, top-right, bottom-left, bottom-right
        int[][] dir = {{0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '#') continue; // skip broken seats
                int idx = i * n + j;
                if (j % 2 == 0) { // Left set (even columns), source -> idx
                    addEdge(source, idx, 1, 0, adj);
                    for (int[] d : dir) {
                        int r = i + d[0], c = j + d[1];
                        if (r >= 0 && r < m && c >= 0 && c < n && 
                            seats[r][c] == '.' && c % 2 == 1) {
                            int neighborIdx = r * n + c;
                            addEdge(idx, neighborIdx, 1, 0, adj);
                        } // right set (idx -> neighborIdx)
                    }
                } 
                else { // Right set (odd columns): connect to sink
                    addEdge(idx, sink, 1, 0, adj);
                }
            } // just use capacity of 1 and cost of 0. its pure maxFlow problem
        } // no need for minCost or spfa/dijk! use ford-fulkerson/edmond-karp
        return adj;
    }

    class Edge {
        int u, v, cap, cost, flow;
        Edge rev;
        Edge(int u, int v, int cap, int cost) {
            this.u = u;
            this.v = v;
            this.cap = cap;
            this.cost = cost;
            this.flow = 0;
        }
    }
    
    private void addEdge(int u, int v, int cap, int cost, 
    List<List<Edge>> adj) {
        Edge edge = new Edge(u, v, cap, cost);
        Edge revEdge = new Edge(v, u, 0, -cost);
        edge.rev = revEdge;
        revEdge.rev = edge;
        adj.get(u).add(edge);
        adj.get(v).add(revEdge);
    }
    
    // Dinic's Algorithm: Level Graph + Blocking Flow
    private int dinics(int source, int sink, List<List<Edge>> adj, int n) {
        int maxFlow = 0;
        int[] levels = new int[n];
        while (bfs(source, sink, levels, adj, n)) {
            int[] iter = new int[n]; // iteration pointer for each node
            int flow;
            while ((flow = dfs(source, sink, Integer.MAX_VALUE, levels,
            iter, adj)) > 0) {
                maxFlow += flow;
            }
        }
        return maxFlow;
    }
    
    private boolean bfs(int source, int sink, int[] levels, 
    List<List<Edge>> adj, int n) {
        Arrays.fill(levels, -1);
        levels[source] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                for (Edge edge : adj.get(u)) {
                    int v = edge.v;
                    int residualCap = edge.cap - edge.flow;
                    if (levels[v] == -1 && residualCap > 0) {
                        levels[v] = level + 1;
                        queue.offer(v);
                    }
                }
            }
            level++;
        }
        return levels[sink] != -1; // return true if sink is reachable
    }
    
    // Find blocking flow using DFS with level constraints
    private int dfs(int u, int sink, int minCap, int[] levels, 
    int[] iter, List<List<Edge>> adj) {
        if (u == sink) return minCap;
        for (int i = iter[u]; i < adj.get(u).size(); i++) {
            Edge edge = adj.get(u).get(i);
            int v = edge.v;
            int residualCap = edge.cap - edge.flow;
            // Only follow edges that go to next level and have capacity
            if (levels[v] == levels[u] + 1 && residualCap > 0) {
                int flow = dfs(v, sink, Math.min(minCap, residualCap), 
                levels, iter, adj);
                if (flow > 0) {
                    edge.flow += flow;
                    edge.rev.flow -= flow;
                    return flow;
                }
            }
            iter[u]++; // optimization: skip this edge in future calls
        }
        return 0;
    }
}