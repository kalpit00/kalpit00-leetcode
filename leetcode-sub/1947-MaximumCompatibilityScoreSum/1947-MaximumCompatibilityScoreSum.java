// Last updated: 6/18/2025, 4:36:06 PM
class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int totalNodes = 2 * m + 2; // students + mentors + source + sink
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) {
            adj.add(new ArrayList<>());
        }
        buildFlowNetwork(students, mentors, adj, m, totalNodes);
        boolean[] inQueue = new boolean[totalNodes];
        int[] mf = minCostMaxFlow(0, totalNodes - 1, inQueue, adj, totalNodes);
        return -mf[1];
    }
    private void buildFlowNetwork(int[][] students, int[][] mentors, List<List<Edge>> adj, int m, int totalNodes) {
        int source = 0, sink = totalNodes - 1;        
        for (int i = 0; i < m; i++) {
            addEdge(source, i + 1, 1, 0, adj);
        }
        // Each student to each mentor: capacity 1, cost = -compatibility_score
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int compatibilityScore = helper(students[i], mentors[j]);
                int cost = -compatibilityScore; // Negative for maximization
                addEdge(i + 1, m + j + 1, 1, cost, adj);
            }
        }        
        // Each mentor to sink: capacity 1, cost 0
        for (int j = 0; j < m; j++) {
            addEdge(m + j + 1, sink, 1, 0, adj);
        }
    }
    // calculate compatiblity
    private int helper(int[] student, int[] mentor) {
        int score = 0;
        for (int k = 0; k < student.length; k++) {
            if (student[k] == mentor[k]) {
                score++;
            }
        }
        return score;
    }
    private int[] minCostMaxFlow(int source, int sink, 
    boolean[] inQueue, List<List<Edge>> adj, int n) {
        int maxFlow = 0, minCost = 0;
        int[] dist = new int[n];
        Edge[] parentEdge = new Edge[n];
        while (spfa(source, sink, dist, parentEdge, inQueue, adj, n)) {
            int flow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parentEdge[v].u) {
                flow = Math.min(flow, parentEdge[v].cap - parentEdge[v].flow);
            }
            for (int v = sink; v != source; v = parentEdge[v].u) {
                parentEdge[v].flow += flow;
                parentEdge[v].rev.flow -= flow;
                minCost += flow * parentEdge[v].cost;
            }
            maxFlow += flow;
        }
        return new int[]{maxFlow, minCost};
    }

    private boolean spfa(int source, int sink, int[] dist,
    Edge[] parentEdge, boolean[] inQueue, List<List<Edge>> adj, int n) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        inQueue[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            inQueue[parent] = false;
            for (Edge edge : adj.get(parent)) {
                int child = edge.v;
                int childDist = dist[parent] + edge.cost;
                if (edge.flow < edge.cap && childDist < dist[child]) {
                    dist[child] = childDist;
                    parentEdge[child] = edge;                    
                    if (!inQueue[child]) {
                        queue.offer(child);
                        inQueue[child] = true;
                    }
                }
            }
        }
        return dist[sink] != Integer.MAX_VALUE;
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
    
    class Edge {
        int u, v, cap, cost, flow;
        Edge rev;
        
        public Edge(int u, int v, int cap, int cost) {
            this.u = u;
            this.v = v;
            this.cap = cap;
            this.cost = cost;
            this.flow = 0;
        }
    }
}