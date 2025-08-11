// Last updated: 8/11/2025, 5:31:59 PM
class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length, steps = -1;
        Queue<int[]> queue = new LinkedList<>();
        outer: // LABEL new trick
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue, n);
                    break outer;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];
                if (grid[x][y] == 1) {
                    return steps;
                }
                for (int[] d : dir) {
                    int r = x + d[0], c = y + d[1];
                    if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] != 2) {
                        queue.offer(new int[]{r, c});
                        if (grid[r][c] == 0) {
                            grid[r][c] = 2; // only mark the 0 to 2
                        } // as we need to return the first 1-cell we poll
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2; // color first island cells to 2!!
        queue.offer(new int[]{i, j});
        for (int[] d : dir) {
            dfs(grid, i + d[0], j + d[1], queue, n);
        }
    }
}   
