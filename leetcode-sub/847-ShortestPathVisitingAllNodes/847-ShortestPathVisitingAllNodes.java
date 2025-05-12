// Last updated: 5/12/2025, 3:50:04 PM
class Solution { // TSP DP + Floyd Warshall!
    public int shortestPathLength(int[][] graph) {
        int n = graph.length, dest = (1 << n) - 1, min = Integer.MAX_VALUE;
        int[][] dist = floyd_warshall(graph);
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        } 
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        } // Held-Karp DP over subsets
        for (int mask = 0; mask <= dest; mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) {
                    continue;
                } 
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) {
                        continue;
                    }
                    int nextMask = mask | (1 << v);
                    dp[nextMask][v] = Math.min(dp[nextMask][v], dp[mask][u] + dist[u][v]);
                }
            }
        }        
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[dest][i]);
        }
        return min;
    }
    private int[][] floyd_warshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            dist[i][i] = 0;
        }
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                dist[u][v] = 1;
            }
        }        
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][m] + dist[m][j]);
                }
            }
        }
        return dist;
    }
}
