// Last updated: 11/8/2025, 10:30:42 PM
class Solution {
    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> 
    connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0), v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited = new int[n], time = new int[n], low = new int[n], 
        parent = new int[n];
        Arrays.fill(parent, -1);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                tarjan(i, parent, visited, adj, time, low, ans);
            }
        }
        return ans;
    }
    private void tarjan(int node, int[] parent, int[] visited,
    List<List<Integer>> adj, int time[], int low[], 
    List<List<Integer>> ans) {
        visited[node] = 1;
        time[node] = low[node] = timer;
        timer++;
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent[node]) {
                continue;
            }
            if (visited[neighbor] == 1) { // back edge, gray to gray
                low[node] = Math.min(low[node], time[neighbor]);
            }
            else if (visited[neighbor] == 0) {
                parent[neighbor] = node;
                tarjan(neighbor, parent, visited, adj, time, low, ans);
                low[node] = Math.min(low[node], low[neighbor]);
                if (low[neighbor] > time[node]) {
                    ans.add(Arrays.asList(neighbor, node));
                }
            }
        }
        visited[node] = 2;
    }
}