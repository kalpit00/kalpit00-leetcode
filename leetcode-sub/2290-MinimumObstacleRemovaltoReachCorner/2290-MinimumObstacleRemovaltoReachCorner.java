// Last updated: 5/12/2025, 3:13:45 PM
class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0, grid[0][0]});
        grid[0][0] = -1;
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!dq.isEmpty()) {
            int[] info = dq.poll();
            int x = info[0], y = info[1], parentCount = info[2];
            if (x == m - 1 && y == n - 1) {
                return parentCount; // count of obstacles at each parent node
            }
            for (int[] d : dirs) {
                int r = x + d[0], c = y + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != -1) {
                    // childCount adds by 1 if cell is obstacle
                    int childCount = parentCount + grid[r][c];
                    if (grid[r][c] == 0) {
                        dq.addFirst(new int[]{r, c, childCount});
                    } // add empty cell to front of deque
                    else {
                        dq.addLast(new int[]{r, c, childCount});
                    } // add obstacle to back of deque
                    grid[r][c] = -1; // mark visited AFTER counting obstacle
                }
            }
        }
        return -1;
    }
}
