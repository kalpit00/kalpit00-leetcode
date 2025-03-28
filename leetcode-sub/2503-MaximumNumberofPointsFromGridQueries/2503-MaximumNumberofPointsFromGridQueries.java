// Last updated: 3/27/2025, 11:33:12 PM
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length, k = queries.length, steps = 0;
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        int[][] sortedQueries = new int[k][2];
        for (int i = 0; i < k; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        for (int[] query : sortedQueries) {
            int val = query[0], idx = query[1];
            while (!pq.isEmpty() && pq.peek()[2] < val) {
                int[] node = pq.poll();
                int x = node[0], y = node[1];
                steps++;
                for (int[] d : dir) {
                    int r = x + d[0], c = y + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                        pq.offer(new int[]{r, c, grid[r][c]});
                        visited[r][c] = true;
                    }
                }
            }
            res[idx] = steps;
        }
        return res;
    }
}