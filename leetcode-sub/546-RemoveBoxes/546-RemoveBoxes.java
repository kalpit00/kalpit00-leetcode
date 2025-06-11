// Last updated: 6/11/2025, 3:12:40 PM
class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        Integer[][][] dp = new Integer[n][n][n];
        return solve(0, n - 1, 0, boxes, dp);
    }

    private int solve(int i, int j, int count, int[] boxes, Integer[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][count] != null) {
            return dp[i][j][count];
        }
        int max = (count + 1) * (count + 1) + solve(i + 1, j, 0, boxes, dp);
        for (int k = i + 1; k <= j; k++) {
            if (boxes[k] == boxes[i]) {
                int left = solve(i + 1, k - 1, 0, boxes, dp);
                int right = solve(k, j, count + 1, boxes, dp);
                max = Math.max(max, left + right);
            }
        }
        return dp[i][j][count] = max;
    }
}
