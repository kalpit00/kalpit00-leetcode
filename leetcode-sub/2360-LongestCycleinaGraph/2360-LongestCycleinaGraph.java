// Last updated: 11/8/2025, 10:47:06 PM
class Solution {
    int timer = 1, max = -1, flag = 0;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                adj.get(i).add(edges[i]);
            }
        }
        int[] visited = new int[n], time = new int[n], low = new int[n], 
        parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                tarjan(i, parent, visited, adj, time, low);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int freq : low) {
            map.put(freq, map.getOrDefault(freq, 0) + 1);
            max = Math.max(max, map.get(freq));
        }
        return flag == 0 ? -1 : max;
    }
    private void tarjan(int node, int[] parent, int[] visited,
    List<List<Integer>> adj, int time[], int low[]) {
        visited[node] = 1;
        time[node] = low[node] = timer;
        timer++;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 1) { // back edge, gray to gray
                flag = 1;
                low[node] = Math.min(low[node], time[neighbor]);
            }
            else if (visited[neighbor] == 0) {
                parent[neighbor] = node;
                tarjan(neighbor, parent, visited, adj, time, low);
                low[node] = Math.min(low[node], low[neighbor]);
            }
        }
        visited[node] = 2;
    }
}