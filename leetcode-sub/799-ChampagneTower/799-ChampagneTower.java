// Last updated: 2/14/2026, 5:26:44 PM
1class Solution {
2    public double champagneTower(int poured, int query_row, int query_glass) {
3        double dp[][] = new double[102][];
4        for (int i = 0; i < dp.length; i++) {
5            dp[i] = new double[i + 1];
6        } // jagged 2d [][]!
7        dp[0][0] = (double) poured;
8        for (int i = 1; i <= query_row; i++) {
9            double n = dp[i - 1][0];
10            dp[i][0] = Math.max(0.0, (n - 1) / 2); 
11            for (int j = 1; j < i; j++) {
12                double n1 = dp[i - 1][j - 1], n2 = dp[i - 1][j];
13                double mid = Math.max(0.0, (n1 - 1) / 2) + Math.max(0.0, (n2 - 1) / 2);
14                dp[i][j] = mid;
15            }
16            dp[i][i] = dp[i][0];
17        }
18        return Math.min(1, dp[query_row][query_glass]);
19    }
20}