// Last updated: 5/8/2026, 9:29:20 PM
1class Solution {
2    public int[][] rotateGrid(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length, count = Math.min(m, n) / 2;
4        for (int x = 0; x < count; x++) {
5            List<Integer> layer = new ArrayList<>();
6            int idx = 0;
7            for (int i = x; i < m - x - 1; i++) layer.add(grid[i][x]);
8            for (int i = x; i < n - x - 1; i++) layer.add(grid[m-x-1][i]);
9            for (int i = m-x-1; i > x; i--) layer.add(grid[i][n-x-1]);
10            for (int i = n-x-1; i > x; i--) layer.add(grid[x][i]);
11            rotate(layer, k);
12            for (int i = x; i < m - x - 1; i++) grid[i][x] = layer.get(idx++);
13            for (int i = x; i < n-x-1; i++) grid[m-x-1][i] = layer.get(idx++);
14            for (int i = m-x-1; i > x; i--) grid[i][n-x-1] = layer.get(idx++);
15            for (int i = n-x-1; i > x; i--) grid[x][i] = layer.get(idx++);
16        }
17        return grid;
18    }
19
20    private void rotate(List<Integer> list, int k) {
21        int n = list.size();
22        k = k % n;
23        reverse(list, 0, n - 1);
24        reverse(list, 0, k - 1);
25        reverse(list, k, n - 1);
26    }
27
28    private void reverse(List<Integer> list, int start, int end) {
29        while (start < end) {
30            int temp = list.get(start);
31            list.set(start, list.get(end));
32            list.set(end, temp);
33            start++;
34            end--;
35        }
36    }
37}