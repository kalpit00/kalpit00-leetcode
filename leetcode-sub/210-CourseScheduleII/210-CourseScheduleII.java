// Last updated: 11/7/2025, 2:25:00 PM
class Solution {
    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int[] visited = new int[n]; // 0 = white, 1 = grey, 2 = black
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(v).add(u);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, visited, adj, stack)) {
                    return new int[]{};
                }
            }
        }
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }
    private boolean dfs(int u, int[] visited, List<List<Integer>> adj,
    Stack<Integer> stack) {
        visited[u] = 1; // gray
        for (int v : adj.get(u)) {
            if (visited[v] == 1) { // gray -> gray, BACK edge == cycle
                return false;
            }
            else if (visited[v] == 0) {
                if (!dfs(v, visited, adj, stack)) {
                    return false;
                }
            }
        }
        stack.push(u);
        visited[u] = 2; // black
        return true;
    }
}