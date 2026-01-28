// Last updated: 1/27/2026, 11:12:24 PM
1class Solution {
2    public int minCost(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
5        int[][][] dist = new int[m][n][k + 1];
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
9            }
10        }        
11        List<int[]> list = new ArrayList<>();
12        for (int i = 0; i < m; i++) {
13            for (int j = 0; j < n; j++) {
14                list.add(new int[]{grid[i][j], i, j});
15            }
16        } // flatten grid into <val, i, j> tuples -> add to list -> revSort
17        list.sort((a, b) -> b[0] - a[0]); // m*n items in this list
18        List<int[]>[] map = new ArrayList[k + 1];
19        for (int i = 0; i <= k; i++) { // make 'k' copies of this sortedList
20            map[i] = new ArrayList<>(list);
21        } // State: (cost, row, col, used_teleports)
22        pq.offer(new int[]{0, 0, 0, 0});
23        dist[0][0][0] = 0;
24        int[][] dir = new int[][]{{0, 1}, {1, 0}};
25        while (!pq.isEmpty()) {
26            int[] curr = pq.poll();
27            int cost = curr[0], r = curr[1], c = curr[2], t = curr[3];
28            if (cost > dist[r][c][t] || (t > 0 && cost >= dist[r][c][t - 1])) {
29                continue;
30            }
31            if (r == m - 1 && c == n - 1) {
32                return cost;
33            }
34            for (int[] d : dir) {
35                int x = r + d[0], y = c + d[1];
36                if (x < 0 || x >= m || y < 0 || y >= n) continue;
37                int newCost = cost + grid[x][y];
38                if (newCost < dist[x][y][t]) {
39                    dist[x][y][t] = newCost;
40                    pq.offer(new int[]{newCost, x, y, t});
41                }
42            }
43            if (t >= k) continue;
44            while (!map[t].isEmpty()) {
45                int[] last = map[t].get(map[t].size() - 1);
46                if (last[0] > grid[r][c]) break; // No more valid destinations
47                int x = last[1], y = last[2];
48                if (cost < dist[x][y][t + 1]) {
49                    dist[x][y][t + 1] = cost;
50                    pq.offer(new int[]{cost, x, y, t + 1});
51                }
52                map[t].remove(map[t].size() - 1);
53            }
54        }        
55        return -1;
56    }
57}