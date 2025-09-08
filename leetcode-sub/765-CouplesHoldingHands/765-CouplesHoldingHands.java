// Last updated: 9/8/2025, 4:13:14 AM
class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2, count = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < 2 * n; i += 2) {
            int u = row[i] / 2, v = row[i + 1] / 2;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++; 
                dfs(adj, i, visited);
            }
        }
        return n - count;
    }
    
    private void dfs(List<List<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited);
            }
        }
    }
}