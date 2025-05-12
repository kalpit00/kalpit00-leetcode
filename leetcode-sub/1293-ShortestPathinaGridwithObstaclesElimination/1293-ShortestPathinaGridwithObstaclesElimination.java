// Last updated: 5/12/2025, 3:07:55 PM
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][0] = true;
        queue.offer(new int[]{0, 0, grid[0][0]});
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] info = queue.poll();
                int x = info[0], y = info[1], parentCount = info[2];
                if (x == m - 1 && y == n - 1) {
                    return steps;
                }
                for (int[] d : dir) {
                    int r = x + d[0], c = y + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        int childCount = parentCount + grid[r][c];
                        if (childCount <= k && !visited[r][c][childCount]) {
                            queue.offer(new int[]{r, c, childCount});
                            visited[r][c][childCount] = true;
                        }                        
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}