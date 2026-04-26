// Last updated: 4/25/2026, 9:39:38 PM
1class Solution {
2    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
3    public boolean containsCycle(char[][] grid) {
4        int m = grid.length, n = grid[0].length;
5        boolean[][] visited = new boolean[m][n];
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                if (!visited[i][j]) {
9                    if (dfs(i, j, m, n, visited, grid, -1, -1, 0)) {
10                        return true;
11                    }
12                }
13            }
14        }
15        return false;
16    }
17    private boolean dfs(int i, int j, int m, int n, boolean[][] visited,
18    char[][] grid, int px, int py, int steps) {
19        if (visited[i][j]) {
20            return steps >= 4;
21        }
22        visited[i][j] = true;
23        for (int[] d : dir) {
24            int r = i + d[0], c = j + d[1];
25            if (r < 0 || r >= m || c < 0 || c >= n) continue;
26            if (r == px && c == py) continue;
27            if (grid[r][c] == grid[i][j]) {
28                if (dfs(r, c, m, n, visited, grid, i, j, steps + 1)) {
29                    return true;
30                }
31            }
32        }
33        return false;
34    }
35}