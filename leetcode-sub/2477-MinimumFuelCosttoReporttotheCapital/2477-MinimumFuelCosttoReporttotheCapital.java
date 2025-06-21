// Last updated: 6/21/2025, 6:22:51 PM
class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        } 
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        long[] dp = new long[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dp, 1);
        Queue<long[]> queue = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (indegree[i] == 1) {
                queue.offer(new long[]{i, 1});
            }
        }
        long sum = 0;
        while (!queue.isEmpty()) {
            long[] item = queue.poll();
            int node = (int) item[0];
            if (visited[node]) continue;
            visited[node] = true;
            long dist = item[1];
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    dp[neighbor] += dist;
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 1 && neighbor != 0) {
                        queue.offer(new long[]{neighbor, dp[neighbor]});
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            sum += Math.ceil((double) dp[i] / seats);
        }
        return sum;
    }
}