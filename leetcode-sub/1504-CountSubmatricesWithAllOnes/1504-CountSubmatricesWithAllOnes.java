// Last updated: 8/21/2025, 4:33:45 AM
class Solution {
    public int numSubmat(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, count = 0;
        int[][] grid = new int[m][n];
        for (int k = 0; k < n; k++) {
            grid[0][k] = matrix[0][k] == 0 ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = matrix[i][j] == 0 ? 0 : grid[i-1][j] + 1;
            }
        }
        for (int i = 0; i < m; i++) {
            count += helper(grid[i]);
        }
        return count;
    }
    public int helper(int[] heights) {
        int n = heights.length, top = -1, res = 0;
        int[] stack = new int[n], PSE = new int[n], pre = new int[n];
        Arrays.fill(PSE, -1);
        for (int i = 0; i < n; i++) {
            while (top != -1 && heights[stack[top]] > heights[i]) {
                int t = stack[top--];
            }
            if (top != -1) {
                PSE[i] = stack[top];
            }
            stack[++top] = i;
        }
        for (int i = 0; i < n; i++) {
            pre[i] = (i - PSE[i]) * heights[i];
            pre[i] += PSE[i] != -1 ? pre[PSE[i]] : 0;
        }
        for (int i = 0; i < n; i++) {
            res += pre[i];
        }
        return res;
    }
}