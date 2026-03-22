// Last updated: 3/21/2026, 8:19:27 PM
1class Solution {
2    public boolean findRotation(int[][] mat, int[][] target) {
3        int n = mat.length;
4        boolean r90 = true, r180 = true, r270 = true, r360 = true;
5        for (int i = 0; i < n; i++) {
6            for (int j = 0; j < n; j++) {
7                r90 &= mat[i][j] == target[n - 1 - j][i];
8                r180 &= mat[i][j] == target[n - 1 - i][n - 1 - j];
9                r270 &= mat[i][j] == target[j][n - 1 - i];
10                r360 &= mat[i][j] == target[i][j];
11            }
12        }
13        return r90 || r180 || r270 || r360;
14    }
15}