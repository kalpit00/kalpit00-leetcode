// Last updated: 11/8/2025, 8:17:06 PM
class Solution {
    int timer = 1;
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int numOfIsland = countIslands(grid);
        if (numOfIsland != 1) return 0;
        int[][] low = new int[m][n], time = new int[m][n];
        int lands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    lands++;
                }
                time[i][j] = -1;
            }
        }
        if (lands == 1) return 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && time[i][j] == -1) {
                    if (tarjans(i, j, grid, low, time, -1)) {
                        return 1;
                    }
                }
            }
        }
        return 2;
    }

    private boolean tarjans(int i, int j, int[][] grid, 
    int[][] low, int[][] time, int p) {
        low[i][j] = time[i][j] = timer;
        int child = 0, m = grid.length, n = grid[0].length;
        timer++;
        for (int[] d : dir) {
            int x = d[0] + i, y = d[1] + j, idx = n * i + j;
            if (x >= 0 && x < m && 
            y >= 0 && y < n && grid[x][y] == 1) {
                if (time[x][y] == -1) {
                    child++;
                    if (tarjans(x, y, grid, low, time, idx)) {
                        return true;
                    }
                    low[i][j] = Math.min(low[i][j], low[x][y]);
                    if (low[x][y] >= time[i][j] && p > -1) {
                        return true;
                    }
                } 
                else if (p != idx) {
                    low[i][j] = Math.min(low[i][j], time[x][y]);
                }
            }
        }
        if (p == -1 && child > 1) {
            return true;
        }
        return false;
    }

    private int countIslands(int[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count++;
                    dfs(visited, grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(boolean[][] visited, int[][] grid, int i, int j, 
    int m, int n) {
        if (i < 0 || j < 0 || i >= m || 
        j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        dfs(visited, grid, i - 1, j, m, n);
        dfs(visited, grid, i + 1, j, m, n);
        dfs(visited, grid, i, j - 1, m, n);
        dfs(visited, grid, i, j + 1, m, n);
    }
}