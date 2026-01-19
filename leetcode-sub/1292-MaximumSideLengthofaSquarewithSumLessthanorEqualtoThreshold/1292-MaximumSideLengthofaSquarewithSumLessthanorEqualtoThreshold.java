// Last updated: 1/18/2026, 7:30:07 PM
1class Solution {
2        
3    public int maxSideLength(int[][] mat, int threshold) {
4        int m = mat.length;
5        int n = mat[0].length;
6        int[][] sum = new int[m + 1][n + 1];
7        
8        int res = 0;
9        int len = 1; // square side length
10
11        for (int i = 1; i <= m; i++) {
12            for (int j = 1; j <= n; j++) {
13                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
14                
15                if (i >= len && j >= len && sum[i][j] - sum[i-len][j] - sum[i][j-len] + sum[i-len][j-len] <= threshold)
16                    res = len++;
17            }
18        }
19        
20        return res;
21    }
22    
23}