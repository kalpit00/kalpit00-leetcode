// Last updated: 1/28/2026, 1:31:01 PM
1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        int[][] dist = new int[m][n];
5        for (int[] r : dist) {
6            Arrays.fill(r, Integer.MAX_VALUE);
7        }
8        dist[0][0] = grid[0][0];
9        int[][] dir = new int[][]{{0, 1}, {1, 0}};
10        Queue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
11        pq.offer(new int[]{0, 0, grid[0][0]});
12        while (!pq.isEmpty()) {
13            int[] node = pq.poll();
14            int r = node[0], c = node[1], parentCost = node[2];
15            // if (parentCost > dist[r][c]) {
16            //     continue;
17            // }
18            if (r == m - 1 && c == n - 1) {
19                return parentCost;
20            }            
21            for (int[] d : dir) {
22                int x = r + d[0], y = c + d[1];
23                if (x < 0 || x >= m || y < 0 || y >= n) continue;
24                int childCost = parentCost + grid[x][y];
25                if (childCost < dist[x][y]) {
26                    dist[x][y] = childCost;
27                    pq.offer(new int[]{x, y, childCost});
28                }
29            }
30        }
31        return grid[0][0];
32    }
33}