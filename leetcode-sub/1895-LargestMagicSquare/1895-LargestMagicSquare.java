// Last updated: 3/4/2026, 10:36:03 PM
1class Solution {
2    public int largestMagicSquare(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4
5        // 1. Row prefix sums: rowP[r][c] = sum of grid[r][0..c]
6        int[][] rowP = new int[m][n];
7        for (int r = 0; r < m; r++)
8            for (int c = 0; c < n; c++)
9                rowP[r][c] = (c > 0 ? rowP[r][c-1] : 0) + grid[r][c];
10
11        // 2. Col prefix sums: colP[r][c] = sum of grid[0..r][c]
12        int[][] colP = new int[m][n];
13        for (int c = 0; c < n; c++)
14            for (int r = 0; r < m; r++)
15                colP[r][c] = (r > 0 ? colP[r-1][c] : 0) + grid[r][c];
16
17        // 3. '\' diagonal prefix: bsP[r][c] = sum along '\' from diagonal-start to (r,c)
18        int[][] bsP = new int[m][n];
19        for (int r = 0; r < m; r++)
20            for (int c = 0; c < n; c++)
21                bsP[r][c] = (r > 0 && c > 0 ? bsP[r-1][c-1] : 0) + grid[r][c];
22
23        // 4. '/' diagonal prefix: slP[r][c] = sum along '/' from diagonal-start to (r,c)
24        // diagonal-start is the BOTTOM-left corner, so we traverse bottom-to-top
25        int[][] slP = new int[m][n];
26        for (int r = m-1; r >= 0; r--)
27            for (int c = 0; c < n; c++)
28                slP[r][c] = (r < m-1 && c > 0 ? slP[r+1][c-1] : 0) + grid[r][c];
29
30        // Helper: sum of row r from col c1..c2
31        // rowSum(r, c1, c2)
32        // Helper: sum of col c from row r1..r2
33        // colSum(r1, r2, c)
34        // Helper: '\' diagonal sum from (r1,c1) to (r2,c2), requires r2-c2==r1-c1, r1<=r2
35        // bsSum(r1,c1,r2,c2)
36        // Helper: '/' diagonal sum from top (r1,c1) to bottom (r2,c2), requires r1+c1==r2+c2
37        // slSum(r1,c1,r2,c2)
38
39        for (int k = Math.min(m, n); k >= 1; k--) {
40            // Slide k×k window: top-left corner is (r, c)
41            for (int r = 0; r + k - 1 < m; r++) {
42                for (int c = 0; c + k - 1 < n; c++) {
43                    int r2 = r + k - 1, c2 = c + k - 1;
44
45                    // Target = first row sum
46                    int target = rowP[r][c2] - (c > 0 ? rowP[r][c-1] : 0);
47
48                    boolean magic = true;
49
50                    // Check all k row sums
51                    for (int i = r; i <= r2; i++) {
52                        int rowSum = rowP[i][c2] - (c > 0 ? rowP[i][c-1] : 0);
53                        if (rowSum != target) { magic = false; break; }
54                    }
55
56                    // Check all k col sums
57                    if (magic) {
58                        for (int j = c; j <= c2; j++) {
59                            int colSum = colP[r2][j] - (r > 0 ? colP[r-1][j] : 0);
60                            if (colSum != target) { magic = false; break; }
61                        }
62                    }
63
64                    // Check '\' diagonal: (r,c) -> (r2,c2)
65                    if (magic) {
66                        int bsPrev = (r > 0 && c > 0) ? bsP[r-1][c-1] : 0;
67                        int bsSum = bsP[r2][c2] - bsPrev;
68                        if (bsSum != target) magic = false;
69                    }
70
71                    // Check '/' diagonal: top is (r, c2), bottom is (r2, c)
72                    if (magic) {
73                        int slPrev = (r2 < m-1 && c > 0) ? slP[r2+1][c-1] : 0;
74                        int slSum = slP[r][c2] - slPrev;
75                        if (slSum != target) magic = false;
76                    }
77
78                    if (magic) return k;
79                }
80            }
81        }
82        return 1;
83    }
84}