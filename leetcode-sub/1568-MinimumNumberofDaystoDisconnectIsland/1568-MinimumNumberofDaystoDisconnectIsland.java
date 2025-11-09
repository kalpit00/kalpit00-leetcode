// Last updated: 11/8/2025, 8:35:55 PM
class Solution {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int timer = 1;
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] numOfIsland = countIslands(grid);
        if (numOfIsland[0] != 1) return 0;
        if (numOfIsland[1] == 1) return 1;
        int[][] low = new int[m][n], time = new int[m][n],
        visited = new int[m][n], parent = new int[m][n];
        for (int[] mat : parent) {
            Arrays.fill(mat, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    if (tarjan(i, j, grid, low, time, visited, parent)) {
                        return 1;
                    }
                }
            }
        }
        return 2;
    }

    private boolean tarjan(int i, int j, int[][] grid, int[][] low, int[][] time, int[][] visited, int[][] parent) {
        low[i][j] = time[i][j] = timer;
        visited[i][j] = 1;
        timer++;
        int m = grid.length, n = grid[0].length, count = 0;
        for (int[] d : dir) {
            int x = d[0] + i, y = d[1] + j;
            if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] == 2 
            || grid[x][y] == 0) {
                continue;
            }
            int neighbor = n * x + y;
            if (neighbor == parent[i][j]) {
                continue;
            }
            
            if (visited[x][y] == 1) { // gray to gray, BACK EDGE
                low[i][j] = Math.min(low[i][j], time[x][y]);
            } 
            else if (visited[x][y] == 0) {
                count++;
                parent[x][y] = n * i + j;
                if (tarjan(x, y, grid, low, time, visited, parent)) {
                    return true;
                }
                low[i][j] = Math.min(low[i][j], low[x][y]);
                if (low[x][y] >= time[i][j] && parent[i][j] > -1) {
                    return true;
                }
            }
        }
        visited[i][j] = 2;
        if (parent[i][j] == -1 && count > 1) {
            return true;
        }
        return false;
    }

    private int[] countIslands(int[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length, lands = 0;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lands += grid[i][j] == 1 ? 1 : 0;
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                    dfs(visited, grid, i, j, m, n);
                }
            }
        }
        return new int[]{count, lands};
    }
    private void dfs(int[][] visited, int[][] grid, int i, int j, int m,int n) {
        visited[i][j] = 1;
        for (int[] d : dir) {
            int x = d[0] + i, y = d[1] + j;
            if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] == 1 
            || grid[x][y] == 0) {
                continue;
            }
            dfs(visited, grid, x, y, m, n);
        }
        // visited[i][j] = 2;
    }
}
