// Last updated: 3/28/2025, 1:54:02 PM
class Solution {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maximumMinutes(int[][] grid) {
        Queue<int[]> fire = new LinkedList<>(), queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fire.add(new int[]{i, j});
                }
            }
        }
        int[] fireSteps = bfs(fire, grid), steps = bfs(queue, grid);
        if (fireSteps[0] == 0 && steps[0] != 0) {
            return (int) 1e9;
        }
        int diff = fireSteps[0] - steps[0];
        if (steps[0] != 0 && diff >= 0) {
            int extra = fireSteps[1] - steps[1] <= diff && 
            fireSteps[2] - steps[2] <= diff ? 1 : 0;
            return diff - extra;
        }
        return -1;
    }
    private int[] bfs(Queue<int[]> queue, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[3];
        int[][] dist = new int[m][n]; // or do boolean[][] + steps/level order
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];
            for (int[] d : dir) {
                int r = x + d[0], c = y + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && 
                grid[r][c] == 0 && dist[r][c] == 0) {
                    dist[r][c] = dist[x][y] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        } // get the three corner cells from bottom right of dist matrix
        res[0] = dist[m - 1][n - 1];
        res[1] = dist[m - 2][n - 1];
        res[2] = dist[m - 1][n - 2];
        return res;
    }
}