// Last updated: 3/21/2026, 8:16:57 PM
1class Solution {
2    public boolean findRotation(int[][] mat, int[][] target) {
3        for (int i = 0; i < 4; i++) {
4            if (isEqual(mat, target)) {
5                return true;
6            }
7            mat = rotate(mat);
8        }
9        return false;
10    }
11    
12    public boolean isEqual(int[][] mat, int[][] res) {
13        int m = mat.length, n = mat[0].length;        
14        for (int i = 0; i < m; i++) {
15            for (int j = 0; j < n; j++) {
16                if (mat[i][j] != res[i][j]) {
17                    return false;
18                }
19            }
20        }
21        return true;
22    }
23    
24    public int[][] rotate (int[][] mat) {
25        int m = mat.length, n = mat[0].length;
26        int[][] res = new int[m][n];
27        for (int i = 0; i < m; i++) {
28            for (int j = 0; j < n; j++) {
29                res[j][n - i - 1] = mat[i][j];
30            }
31        }
32        return res;
33    }
34}