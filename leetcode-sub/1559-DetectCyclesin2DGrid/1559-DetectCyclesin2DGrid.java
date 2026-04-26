// Last updated: 4/25/2026, 9:38:19 PM
1class Solution {
2    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
3    public boolean containsCycle(char[][] grid) {
4        int m = grid.length, n = grid[0].length;
5        boolean[][] visited = new boolean[m][n];
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                if (!visited[i][j] && 
9                dfs(grid, i, j, m, n, -1, -1, 0, visited)) {
10                    return true;
11                }
12            }
13        }
14        return false;
15    }
16    
17    private boolean dfs(char[][] grid, int x, int y, int m, int n, int px, int py, int steps, boolean[][] visited) {
18        if (visited[x][y]) {
19            return steps >= 4;
20        }
21        visited[x][y] = true;
22        for (int[] d : dir) {
23            int nx = x + d[0], ny = y + d[1];
24            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
25            if (nx == px && ny == py) continue;
26            if (grid[nx][ny] == grid[x][y]) {
27                if (dfs(grid, nx, ny, m, n, x, y, steps + 1, visited)) {
28                    return true;
29                }
30            }
31        }
32        return false;
33    }
34}