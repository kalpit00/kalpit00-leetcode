// Last updated: 3/12/2026, 3:22:13 AM
1class Solution {
2    public int[][] resultGrid(int[][] img, int threshold) {
3        int m = img.length, n = img[0].length;
4        int[][][] mat = new int[m][n][2];
5        int[][] res = new int[m][n];
6        for (int i = 1; i < m - 1; i++) {
7            for (int j = 1; j < n - 1; j++) {
8                int sum = 0;
9                boolean flag = true;
10                for (int x = i - 1; x <= i + 1; x++) {
11                    for (int y = j - 1; y <= j + 1; y++) {
12                        if (x >= 0 && x < m && y >= 0 && y < n) {
13                            if (y <= j && Math.abs(img[x][y] - img[x][y + 1]) > 
14                            threshold) {
15                                flag = false;
16                            }
17                            if (x <= i && Math.abs(img[x][y] - img[x + 1][y]) >
18                            threshold) {
19                                flag = false;
20                            }
21                            sum += img[x][y];
22                        }
23                    }
24                }
25                int avg = sum / 9;
26                if (flag) {
27                    for (int x = i - 1; x <= i + 1; x++) {
28                        for (int y = j - 1; y <= j + 1; y++) {
29                            if (x >= 0 && x < m && y >= 0 && y < n) {
30                                mat[x][y][0] += avg;
31                                mat[x][y][1]++;
32                            }
33                        }
34                    }
35                }
36            }
37        }
38        for (int i = 0; i < m; i++) {
39            for (int j = 0; j < n; j++) {
40                res[i][j] = mat[i][j][1] == 0 ? img[i][j] : 
41                mat[i][j][0] / mat[i][j][1];
42            }
43        }
44        return res;
45    }
46}