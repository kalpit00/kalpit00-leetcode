// Last updated: 11/8/2025, 4:48:04 AM
class Solution {
    int idx;
    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        idx = n - 1;
        int[] res = new int[n];
        int[] visited = new int[n]; // 0 = white, 1 = grey, 2 = black
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(v).add(u);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, visited, adj, res)) {
                    return new int[]{};
                }
            }
        }
        return res;
    }
    private boolean dfs(int u, int[] visited, List<List<Integer>> adj,
    int[] res) {
        visited[u] = 1; // gray
        for (int v : adj.get(u)) {
            if (visited[v] == 1) { // gray -> gray, BACK edge == cycle
                return false;
            }
            else if (visited[v] == 0) {
                if (!dfs(v, visited, adj, res)) {
                    return false;
                }
            }
        }
        res[idx--] = u;
        visited[u] = 2; // black
        return true;
    }
}