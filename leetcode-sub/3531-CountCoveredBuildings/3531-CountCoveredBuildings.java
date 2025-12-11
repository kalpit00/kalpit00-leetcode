// Last updated: 12/10/2025, 7:53:26 PM
1class Solution {
2
3    public int countCoveredBuildings(int n, int[][] buildings) {
4        int[] maxRow = new int[n + 1];
5        int[] minRow = new int[n + 1];
6        int[] maxCol = new int[n + 1];
7        int[] minCol = new int[n + 1];
8        Arrays.fill(minRow, n + 1);
9        Arrays.fill(minCol, n + 1);
10        for (int[] p : buildings) {
11            int x = p[0];
12            int y = p[1];
13            maxRow[y] = Math.max(maxRow[y], x);
14            minRow[y] = Math.min(minRow[y], x);
15            maxCol[x] = Math.max(maxCol[x], y);
16            minCol[x] = Math.min(minCol[x], y);
17        }
18        int res = 0;
19        for (int[] p : buildings) {
20            int x = p[0];
21            int y = p[1];
22            if (
23                x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]
24            ) {
25                res++;
26            }
27        }
28        return res;
29    }
30}