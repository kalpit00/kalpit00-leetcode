// Last updated: 7/11/2025, 1:05:06 AM
class Solution {
    int max = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        int[] visited = new int[n]; // stores no of times node i is visited
        visited[0]++; // start by visited node 0 and taking its value[0]
        dfs(adj, 0, values[0], maxTime, values, visited);
        return max;
    }
    private void dfs(List<List<int[]>> adj, int i, int sum, int remainingTime,
    int[] values, int[] visited) {
        if (i == 0) { // when reach 0 again, max across all possible pathSums
            max = Math.max(max, sum);
        }
        for (int[] neighbor : adj.get(i)) {
            int j = neighbor[0], time = neighbor[1];
            if (remainingTime < time) {
                continue;
            } // if not enough time to go to next neighbor, skip him
            visited[j]++; // add values[j] if first time seeing node "j"
            dfs(adj, j, sum + (visited[j] == 1 ? values[j] : 0),
            remainingTime - time, values, visited);
            visited[j]--; // backtrack
        }
    }
}