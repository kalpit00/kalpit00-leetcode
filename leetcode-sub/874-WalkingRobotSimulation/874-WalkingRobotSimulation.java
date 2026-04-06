// Last updated: 4/5/2026, 8:31:45 PM
1class Solution {
2    public int robotSim(int[] commands, int[][] obstacles) {
3        Set<String> set = new HashSet<>();
4        for (int[] obs : obstacles) {
5            set.add(obs[0] + " " + obs[1]);
6        }
7        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
8        int d = 0, x = 0, y = 0, max = 0;
9        for (int c : commands) {
10            if (c == -1) {
11                d = (d + 1) % 4;
12            } 
13            else if (c == -2) {
14                d = (d + 3) % 4;
15            } 
16            else {
17                for (int i = 0; i < c; i++) {
18                    int nx = x + dirs[d][0];
19                    int ny = y + dirs[d][1];
20                    if (set.contains(nx + " " + ny)) break;
21                    x = nx;
22                    y = ny;
23                }
24            }
25            max = Math.max(max, x * x + y * y);
26        }
27        return max;
28    }
29}