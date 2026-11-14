// Last updated: 11/13/2026, 11:41:26 PM
1class Solution {
2    public int[][] colorGrid(int m, int n, int[][] sources) {
3        int[][] res = new int[m][n];
4        Queue<int[]> queue = new LinkedList<>();
5        Arrays.sort(sources, (a, b) -> b[2] - a[2]);
6        for (int[] node : sources) {
7            int i = node[0], j = node[1], k = node[2];
8            if (res[i][j] == 0) {
9                res[i][j] = k;
10                queue.offer(new int[]{i, j});
11            }
12        }
13        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
14        while (!queue.isEmpty()) {
15            int size = queue.size();
16            for (int k = 0; k < size; k++) {
17                int[] node = queue.poll();
18                int x = node[0], y = node[1];
19                for (int[] d : dir) {
20                    int r = x + d[0], c = y + d[1];
21                    if (r >= 0 && r < m && c >= 0 && c < n && res[r][c] == 0) {
22                        res[r][c] = res[x][y];
23                        queue.offer(new int[]{r, c});
24                    }
25                }
26            }
27        }
28        return res;
29    }
30}