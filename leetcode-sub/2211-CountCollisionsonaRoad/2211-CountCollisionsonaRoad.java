// Last updated: 6/29/2025, 2:12:32 AM
class Solution {
    public boolean isPrintable(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= 60; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[61];
        for (int k = 1; k <= 60; k++) {
            int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE};
            int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == k) {
                        min[0] = Math.min(min[0], i);
                        min[1] = Math.min(min[1], j);
                        max[0] = Math.max(max[0], i);
                        max[1] = Math.max(max[1], j);
                    }
                }
                if (min[0] == Integer.MAX_VALUE) continue;
            }
            for (int i = min[0]; i <= max[0]; i++) {
                for (int j = min[1]; j <= max[1]; j++) {
                    if (grid[i][j] == k) continue;
                    adj.get(grid[i][j]).add(k);
                    indegree[k]++;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= 60; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return count == 61;
    }
}