// Last updated: 1/18/2026, 3:50:43 AM
1class Solution {
2    public int largestMagicSquare(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        
6        long[][] rowPrefix = new long[n][m + 1];
7        long[][] colPrefix = new long[n + 1][m];
8        
9        for (int i = 0; i < n; i++) {
10            for (int j = 0; j < m; j++) {
11                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
12            }
13        }
14        
15        for (int j = 0; j < m; j++) {
16            for (int i = 0; i < n; i++) {
17                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];
18            }
19        }
20        
21        for (int k = Math.min(n, m); k > 1; k--) {
22            for (int r = 0; r <= n - k; r++) {
23                for (int c = 0; c <= m - k; c++) {
24                    
25                    long target = rowPrefix[r][c + k] - rowPrefix[r][c];
26                    boolean isMagic = true;
27                    
28                    for (int i = 0; i < k; i++) {
29                        long currRowSum = rowPrefix[r + i][c + k] - rowPrefix[r + i][c];
30                        if (currRowSum != target) {
31                            isMagic = false;
32                            break;
33                        }
34                    }
35                    if (!isMagic) continue;
36                
37                    for (int j = 0; j < k; j++) {
38                        long currColSum = colPrefix[r + k][c + j] - colPrefix[r][c + j];
39                        if (currColSum != target) {
40                            isMagic = false;
41                            break;
42                        }
43                    }
44                    if (!isMagic) continue;
45                    
46                    long d1 = 0, d2 = 0;
47                    for (int i = 0; i < k; i++) {
48                        d1 += grid[r + i][c + i];
49                        d2 += grid[r + i][c + k - 1 - i];
50                    }
51                    
52                    if (d1 == target && d2 == target) {
53                        return k;
54                    }
55                }
56            }
57        }
58        
59        return 1;
60    }
61}