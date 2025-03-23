// Last updated: 3/23/2025, 7:29:11 AM
class Solution {
    public int countPaths(int n, int[][] roads) {
        // dijsktra + dp problem
        int mod = 1000000007;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], wt = road[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        long[] dist = new long[n]; // stores minCost till node i from src 0
        int[] dp = new int[n]; // stores no of ways to get to node i from src 0
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        dp[0] = 1;
        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        queue.offer(new long[]{0, 0});
        while (!queue.isEmpty()) {
            long[] info = queue.poll();
            int parent = (int) info[0];
            long d = info[1];
            for (int[] neighbor : adj.get(parent)) {
                int child = neighbor[0], time = neighbor[1];
                if (dist[child] > d + time) {
                    dist[child] = d + time;
                    dp[child] = dp[parent];
                    queue.offer(new long[]{child, dist[child]});
                }
                else if (dist[child] == d + time) {
                    dp[child] = (dp[child] + dp[parent]) % mod;
                }
            }
        }
        return dp[n - 1];
    }
}