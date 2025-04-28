// Last updated: 4/28/2025, 3:09:05 PM
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[102][102];
        dp[0][0] = (double) poured;
        for (int i = 1; i <= query_row; i++) {
            double n = dp[i - 1][0];
            dp[i][0] = Math.max(0.0, (n - 1) / 2); 
            for (int j = 1; j < i; j++) {
                double n1 = dp[i - 1][j - 1], n2 = dp[i - 1][j];
                double mid = Math.max(0.0, (n1 - 1) / 2) + Math.max(0.0, (n2 - 1) / 2);
                dp[i][j] = mid;
            }
            dp[i][i] = dp[i][0];
        }
        return Math.min(1, dp[query_row][query_glass]);
    }
}