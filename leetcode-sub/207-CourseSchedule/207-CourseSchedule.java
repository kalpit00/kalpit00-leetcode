// Last updated: 11/3/2025, 4:42:27 AM
class Solution {
    public boolean canFinish(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] visited = new int[n]; // 0 = white, 1 = grey, 2 = black
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(v).add(u);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, visited, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int u, int[] visited, List<List<Integer>> adj) {
        visited[u] = 1; // gray
        for (int v : adj.get(u)) {
            if (visited[v] == 1) { // gray -> gray, BACK edge == cycle
                return false;
            }
            else if (visited[v] == 0) {
                if (!dfs(v, visited, adj)) {
                    return false;
                }
            }
        }
        visited[u] = 2; // black
        return true;
    }
}