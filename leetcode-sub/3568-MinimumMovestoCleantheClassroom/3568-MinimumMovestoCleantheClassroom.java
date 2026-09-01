// Last updated: 9/1/2026, 3:18:49 AM
1class Solution {
2    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};    
3    public int minMoves(String[] classroom, int energyMax) {
4        int m = classroom.length, n = classroom[0].length(), x = -1, y = -1;
5        char[][] grid = new char[m][n];
6        List<int[]> list = new ArrayList<>();
7        for (int i = 0; i < m; i++) {
8            grid[i] = classroom[i].toCharArray();
9            for (int j = 0; j < n; j++) {
10                char ch = grid[i][j];
11                if (ch == 'S') {
12                    x = i;
13                    y = j;
14                }
15                else if (ch == 'L') {
16                    list.add(new int[]{i, j});
17                }
18            }
19        }
20        int count = list.size(), dest = (1 << count) - 1;
21        Queue<int[]> queue = new LinkedList<>();
22        queue.offer(new int[]{x, y, energyMax, 0, 0});
23        int[][][] visited = new int[m][n][1 << count];
24        for (int[][] mat : visited) {
25            for (int[] a : mat) {
26                Arrays.fill(a, -1);
27            }
28        }
29        visited[x][y][0] = energyMax;        
30        while (!queue.isEmpty()) {
31            int[] node = queue.poll();
32            int i = node[0], j = node[1], energy = node[2], 
33            mask = node[3], steps = node[4];
34            if (mask == dest) {
35                return steps;
36            }
37            for (int[] d : dir) {
38                int r = d[0] + i, c = d[1] + j;
39                if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 'X') {
40                    continue;
41                }
42                char ch = grid[r][c];
43                int childEnergy = energy - 1;
44                if (childEnergy < 0) continue;
45                if (ch == 'R') {
46                    childEnergy = energyMax;
47                }
48                int childMask = mask;
49                if (ch == 'L') {
50                    for (int k = 0; k < count; k++) {
51                        int[] item = list.get(k);
52                        if (item[0] == r && item[1] == c) {
53                            childMask |= (1 << k);
54                            break;
55                        }
56                    }
57                }
58                if (visited[r][c][childMask] < childEnergy) {
59                    visited[r][c][childMask] = childEnergy;
60                    queue.offer(new int[]{r, c, childEnergy, childMask, steps + 1});
61                }
62            }
63        }
64        return -1;
65    }
66}