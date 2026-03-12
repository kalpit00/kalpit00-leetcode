// Last updated: 3/12/2026, 3:20:44 AM
1class Solution {
2    public int[][] resultGrid(int[][] img, int threshold) {
3        int m = img.length, n = img[0].length;
4        List<Integer>[][] mat = new List[m][n];
5        int[][] res = new int[m][n];
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                mat[i][j] = new ArrayList<>();
9            }
10        }
11        for (int i = 1; i < m - 1; i++) {
12            for (int j = 1; j < n - 1; j++) {
13                int sum = 0;
14                boolean flag = true;
15                for (int x = i - 1; x <= i + 1; x++) {
16                    for (int y = j - 1; y <= j + 1; y++) {
17                        if (x >= 0 && x < m && y >= 0 && y < n) {
18                            if (y <= j && Math.abs(img[x][y] - img[x][y + 1]) > 
19                            threshold) {
20                                flag = false;
21                            }
22                            if (x <= i && Math.abs(img[x][y] - img[x + 1][y]) >
23                            threshold) {
24                                flag = false;
25                            }
26                            sum += img[x][y];
27                        }
28                    }
29                }
30                int avg = sum / 9;
31                if (flag) {
32                    for (int x = i - 1; x <= i + 1; x++) {
33                        for (int y = j - 1; y <= j + 1; y++) {
34                            if (x >= 0 && x < m && y >= 0 && y < n) {
35                                mat[x][y].add(avg);
36                            }
37                        }
38                    }
39                }
40            }
41        }
42        for (int i = 0; i < m; i++) {
43            for (int j = 0; j < n; j++) {
44                int sum = 0;
45                for (Integer num : mat[i][j]) {
46                    sum += num;
47                }
48                res[i][j] = mat[i][j].isEmpty() ? img[i][j] : 
49                sum / mat[i][j].size();
50            }
51        }
52        return res;
53    }
54}