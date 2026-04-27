// Last updated: 4/27/2026, 2:30:19 AM
1class Solution {
2    public boolean hasValidPath(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        boolean[][] visited = new boolean[m][n];
5        Queue<int[]> queue = new LinkedList<>();
6        queue.add(new int[]{0, 0});
7        visited[0][0] = true;
8        while (!queue.isEmpty()) {
9            int[] curr = queue.poll();
10            int x = curr[0], y = curr[1];
11            int num = grid[x][y] - 1;
12            for (int[] d : dirs[num]) {
13                int nx = x + d[0], ny = y + d[1];
14                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
15                    continue;
16                }
17                for (int[] backDir : dirs[grid[nx][ny] - 1]) {
18                    if (nx + backDir[0] == x && ny + backDir[1] == y) {
19                        visited[nx][ny] = true;
20                        queue.add(new int[]{nx, ny});
21                    }
22                }   
23            }
24        }
25        return visited[m - 1][n - 1];
26    }
27    int[][][] dirs = {
28                {{0, -1}, {0, 1}},
29                {{-1, 0}, {1, 0}},
30                {{0, -1}, {1, 0}},
31                {{0, 1}, {1, 0}},
32                {{0, -1}, {-1, 0}},
33                {{0, 1}, {-1, 0}}
34    };
35}