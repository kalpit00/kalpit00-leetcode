// Last updated: 5/19/2026, 6:47:38 AM
1class Solution {
2    public int oddCells(int m, int n, int[][] indices) {
3        boolean[] row = new boolean[m];
4        boolean[] col = new boolean[n];
5        
6        for (int i = 0; i < indices.length; i++) {
7            row[indices[i][0]] ^= true;
8            col[indices[i][1]] ^= true;
9        }
10        int rCount = 0;
11        int cCount = 0;
12        
13        for (int i = 0; i < m; i++) {
14            if (row[i]) {
15                rCount++;
16            }
17        }
18        for (int i = 0; i < n; i++) {
19            if (col[i]) {
20                cCount++;
21            }
22        }
23        return rCount*n + cCount*m - 2*rCount*cCount;
24    }
25}