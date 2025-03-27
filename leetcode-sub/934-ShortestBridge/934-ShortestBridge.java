// Last updated: 3/27/2025, 3:45:11 PM
class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length, steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        outer: // LABEL new trick
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited, queue, n);
                    break outer;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];      
                for (int[] d : dir) {
                    int r = x + d[0], c = y + d[1];
                    if (r >= 0 && r < n && c >= 0 && c < n && 
                    !visited[r][c]) {
                        if (grid[r][c] == 1) {
                            return steps;
                        }
                        else {
                            visited[r][c] = true;
                            queue.offer(new int[]{r, c});
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited,
    Queue<int[]> queue, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1 || 
        visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] d : dir) {
            dfs(grid, i + d[0], j + d[1], visited, queue, n);
        }
    }
}   
