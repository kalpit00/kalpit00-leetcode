// Last updated: 5/8/2025, 1:52:45 AM
class Solution {
    public int minTimeToReach(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{0, 0, 0, 1}); 
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1], parentMax = node[2], parity = node[3];
            if (x == m - 1 && y == n - 1) {
                return parentMax;
            }
            for (int[] d : dir) {
                int r = x + d[0], c = y + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                    visited[r][c] = true;
                    int wait = (parity == 1) ? 1 : 2;
                    int childMax = wait + Math.max(parentMax, grid[r][c]);
                    queue.offer(new int[]{r, c, childMax, 1 - parity});
                }
            }
        }
        return -1;
    }
}
