// Last updated: 6/9/2026, 8:00:56 PM
1class Solution {
2    public int minTimeToReach(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        boolean[][] visited = new boolean[m][n];
5        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
6        queue.offer(new int[]{0, 0, 0, 1}); 
7        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
8        while (!queue.isEmpty()) {
9            int[] node = queue.poll();
10            int x = node[0], y = node[1], parentMax = node[2], parity = node[3];
11            if (x == m - 1 && y == n - 1) {
12                return parentMax;
13            }
14            for (int[] d : dir) {
15                int r = x + d[0], c = y + d[1];
16                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
17                    visited[r][c] = true;
18                    int wait = (parity == 1) ? 1 : 2;
19                    int childMax = wait + Math.max(parentMax, grid[r][c]);
20                    queue.offer(new int[]{r, c, childMax, 1 - parity});
21                }
22            }
23        }
24        return -1;
25    }
26}
27