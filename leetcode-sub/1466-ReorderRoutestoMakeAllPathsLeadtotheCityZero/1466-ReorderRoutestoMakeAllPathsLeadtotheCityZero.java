// Last updated: 7/26/2025, 2:55:45 PM
class Solution {
    int count = 0;
    public int minReorder(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        for (int[] edge : edges) {
            int parent = edge[0], child = edge[1];
            adj.get(parent).add(new int[]{child, 1});
            adj.get(child).add(new int[]{parent, -1});
// parent -> child is forward direction, so push 1, child to parent is -1
        }
        boolean[] visited = new boolean[n];
        dfs(0, adj, visited);
        return count;
    }
    private void dfs(int node, List<List<int[]>> adj, boolean[] visited) {
        visited[node] = true;
        for (int[] neighbor : adj.get(node)) {
            int child = neighbor[0], direction = neighbor[1];
            if (!visited[child]) {
// if direction from parent to child is forwards, reverse the edge. count it
                count += direction == 1 ? 1 : 0;
                dfs(child, adj, visited);
            }
        }
    }
}