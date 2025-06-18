// Last updated: 6/18/2025, 4:26:31 PM
class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int n = nums.length;
        int totalNodes = n + numSlots + 2; // nums + slots + source + sink
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) {
            adj.add(new ArrayList<>());
        }
        buildFlowNetwork(nums, numSlots, adj, n, totalNodes);
        int[] potential = new int[totalNodes];
        int[] mf = minCostMaxFlow(0, totalNodes - 1, potential, adj, totalNodes);
        return -mf[1];
    }
    
    private void buildFlowNetwork(int[] nums, int numSlots, List<List<Edge>> adj, int n, int totalNodes) {
        int source = 0, sink = totalNodes - 1;
        // Source to each number: capacity 1, cost 0
        for (int i = 0; i < n; i++) {
            addEdge(source, i + 1, 1, 0, adj);
        }
        
        // Each number to each slot: capacity 1, cost = -(nums[i] & slotNumber)
        for (int i = 0; i < n; i++) {
            for (int slot = 1; slot <= numSlots; slot++) {
                int cost = -(nums[i] & slot); // Negative for maximization
                addEdge(i + 1, n + slot, 1, cost, adj);
            }
        }
        
        // Each slot to sink: capacity 2 (each slot can hold 2 numbers), cost 0
        for (int slot = 1; slot <= numSlots; slot++) {
            addEdge(n + slot, sink, 2, 0, adj);
        }
    }
    
    private int[] minCostMaxFlow(int source, int sink, 
    int[] potential, List<List<Edge>> adj, int n) {
        int maxFlow = 0, minCost = 0;
        int[] dist = new int[n];
        Edge[] parentEdge = new Edge[n];
        while (dijkstra(source, sink, dist, parentEdge, potential, adj, n)) {
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

    private boolean dijkstra(int source, int sink, int[] dist,
    Edge[] parentEdge, int[] potential, List<List<Edge>> adj, int n) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{source, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int parent = node[0], parentDist = node[1];
            if (parentDist > dist[parent]) continue; // dijkstra pruning step
            for (Edge edge : adj.get(parent)) {
                int child = edge.v;
                int childDist = dist[parent] + edge.cost + 
                potential[parent] - potential[child];
                if (edge.flow < edge.cap && childDist < dist[child]) {
                    dist[child] = childDist;
                    parentEdge[child] = edge;
                    pq.offer(new int[]{child, dist[child]});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                potential[i] += dist[i];
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