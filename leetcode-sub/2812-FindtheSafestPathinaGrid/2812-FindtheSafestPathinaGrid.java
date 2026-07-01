// Last updated: 6/30/2026, 8:21:56 PM
1class Solution {
2    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
3    public int maximumSafenessFactor(List<List<Integer>> grid) {
4        int n = grid.size();
5        if (grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) {
6            return 0;
7        }
8        int[][] mat = new int[n][n];
9        bfs(grid, mat, n); // multi src bfs
10        return minimax(mat, n); // minimax dijkstra
11    }
12
13    private void bfs(List<List<Integer>> grid, int[][] mat, int n) {
14        boolean[][] visited = new boolean[n][n];
15        Queue<int[]> queue = new LinkedList<>();
16        for (int r = 0; r < n; r++) {
17            for (int c = 0; c < n; c++) {
18                if (grid.get(r).get(c) == 1) {
19                    queue.offer(new int[]{r, c});
20                    mat[r][c] = 0; // thief cells have safeness = 0
21                    visited[r][c] = true;
22                }
23            }
24        } // multi src bfs starting from every "thief" cell offered to queue
25        while (!queue.isEmpty()) {
26            int[] node = queue.poll();
27            int x = node[0], y = node[1];
28            for (int[] d : dir) {
29                int r = x + d[0], c = y + d[1];
30                if (r >= 0 && r < n && c >= 0 && c < n && !visited[r][c]) {
31                    visited[r][c] = true;
32                    mat[r][c] = mat[x][y] + 1;
33                    queue.offer(new int[]{r, c});
34                }
35            }
36        }
37    }
38
39    private int minimax(int[][] mat, int n) {
40        // use maxHeap to get maximum safeness! descending order
41        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
42        pq.offer(new int[]{0, 0, mat[0][0]}); // <cell, safeness of cell>
43        boolean[][] visited = new boolean[n][n];
44        while (!pq.isEmpty()) {
45            int[] node = pq.poll();
46            int x = node[0], y = node[1], safeness = node[2];
47            if (x == n - 1 && y == n - 1) {
48                return safeness;
49            }
50            if (visited[x][y]) {
51                continue;
52            }
53            visited[x][y] = true;
54            for (int[] d : dir) {
55                int r = x + d[0], c = y + d[1];
56                if (r >= 0 && r < n && c >= 0 && c < n && !visited[r][c]) {
57                    int childSafeness = Math.min(safeness, mat[r][c]);
58                    pq.offer(new int[]{r, c, childSafeness});
59                }
60            }
61        }
62        return -1;
63    }
64}
65