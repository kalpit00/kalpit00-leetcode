// Last updated: 4/15/2026, 7:14:01 PM
1class Solution {
2    public List<Integer> zigzagTraversal(int[][] grid) {
3        List<Integer> list = new ArrayList<>();
4        int m = grid.length, n = grid[0].length;
5        boolean flag = true, dir = true;
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                if (flag) {
9                    if (dir) {
10                        list.add(grid[i][j]);
11                    }
12                    else {
13                        list.add(grid[i][n - j - 1]);
14                    }
15                }
16                flag = !flag;
17         
18            }
19            dir = !dir;
20        }
21        return list;
22    }
23}