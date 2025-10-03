// Last updated: 10/2/2025, 8:17:01 PM
class Solution {
    public int trapRainWater(int[][] grid) {
        int m = grid.length, n = grid[0].length, k = m * n, sum = 0;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int parent = i * n + j;
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    adj.get(k).add(new int[]{parent, 0});
                }
                for (int[] d : dir) {
                    int r = i + d[0], c = j + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        int child = r * n + c;
                        adj.get(parent).add(new int[]{child, grid[i][j]});
                    }
                }
            }
        }
        int[] dist = dijkstra(adj, k);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = dist[i * n + j];
                sum += min > grid[i][j] ? min - grid[i][j] : 0;
            }
        }
        return sum;
    }
    private int[] dijkstra(List<List<int[]>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int parent = info[0], parentDist = info[1];
            for (int[] neighbor : adj.get(parent)) {
                int child = neighbor[0], edgeWeight = neighbor[1];
                int childDist = Math.max(parentDist, edgeWeight);
                if (dist[child] > childDist) {
                    dist[child] = childDist;
                    pq.offer(new int[]{child, childDist});
                }
            }
        }
        return dist;
    }
}