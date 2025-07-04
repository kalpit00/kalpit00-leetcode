// Last updated: 6/7/2025, 10:05:09 PM
class Solution {
    public int minimumMoves(int[][] grid) {
        int n = grid.length, steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        boolean[][][] visited = new boolean[n][n][2];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int r = node[0], c = node[1], dir = node[2];
                if (r == n - 1 && c == n - 2 && dir == 0) {
                    return steps;
                }
                if (!visited[r][c][dir]) {
                    visited[r][c][dir] = true;
                    if (dir == 0) { // horizontal
                        if (r + 1 < n && c + 1 < n && 
                        grid[r + 1][c] == 0 && grid[r + 1][c + 1] == 0) {
                            int[] horizontal_down = new int[]{r + 1, c, 0};
                            int[] verticalRotate = new int[]{r, c, 1};
                            queue.offer(horizontal_down);
                            queue.offer(verticalRotate);
                        }
                        if (c + 2 < n && grid[r][c + 2] == 0) {
                            int[] horizontal_right = new int[]{r, c + 1, 0};
                            queue.offer(horizontal_right);
                        }
                    }
                    else { // vertical
                        if (r + 1 < n && c + 1 < n && 
                        grid[r][c + 1] == 0 && grid[r + 1][c + 1] == 0) {
                            int[] verticalRight = new int[]{r, c + 1, 1};
                            int[] horizontalRotate = new int[]{r, c, 0};
                            queue.offer(verticalRight);
                            queue.offer(horizontalRotate);
                        }
                        if (r + 2 < n && grid[r + 2][c] == 0) {
                            int[] verticalDown = new int[]{r + 1, c, 1};
                            queue.offer(verticalDown);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}