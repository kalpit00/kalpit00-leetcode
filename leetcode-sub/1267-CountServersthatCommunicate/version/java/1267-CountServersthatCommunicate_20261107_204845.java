// Last updated: 11/7/2026, 8:48:45 PM
1class Solution {
2    public int countServers(int[][] grid) {
3        int count = 0, m = grid.length, n = grid[0].length;
4        int[] r = new int[m], c = new int[n];
5        for (int i = 0; i < m; i++) {
6            for (int j = 0; j < n; j++) {
7                if (grid[i][j] == 1) {
8                    r[i]++;
9                    c[j]++;
10                }
11            }
12        }
13        for (int i = 0; i < m; i++) {
14            for (int j = 0; j < n; j++) {
15                if (grid[i][j] == 1 && (r[i] > 1 || c[j] > 1)) {
16                    count++;
17                }
18            }
19        }
20        return count;
21    }
22}