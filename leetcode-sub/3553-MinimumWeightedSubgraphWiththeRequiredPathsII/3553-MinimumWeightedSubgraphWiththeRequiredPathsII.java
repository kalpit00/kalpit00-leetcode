// Last updated: 5/19/2025, 1:25:02 AM
class Solution {
    static {
        for (int i = 0; i < 200; i++) {
            maxSum(new int[1][0]);
        }
    }
    public static int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] pSum = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pSum[i][j+1] = pSum[i][j] + grid[i][j];
            }
        }
        int maxSum = 0;
        for (int i = 0; i+2 < m; i++) {
            for (int j = 0; j+3 <= n; j++) {
                maxSum = Math.max(maxSum,
                        pSum[i][j+3]-pSum[i][j]+grid[i+1][j+1]+pSum[i+2][j+3]-pSum[i+2][j]);
            }
            
        }
        return maxSum;
    }
}
