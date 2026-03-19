// Last updated: 3/18/2026, 9:30:59 PM
1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int rows = grid.length, cols = grid[0].length;
4        int[] sumX = new int[cols];
5        int[] sumY = new int[cols];
6        int res = 0;
7
8        for (int i = 0; i < rows; i++) {
9            int rx = 0, ry = 0;
10
11            for (int j = 0; j < cols; j++) {
12                if (grid[i][j] == 'X') rx++;
13                else if (grid[i][j] == 'Y') ry++;
14
15                sumX[j] += rx;
16                sumY[j] += ry;
17
18                if (sumX[j] > 0 && sumX[j] == sumY[j]) res++;
19            }
20        }
21
22        return res;
23    }
24}