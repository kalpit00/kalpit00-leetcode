// Last updated: 8/21/2025, 4:32:14 AM
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
        int n = heights.length, sum = 0;
        Stack<Integer> stack = new Stack<>();
        int[] PSE = new int[n], pre = new int[n];
        Arrays.fill(PSE, -1);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int top = stack.pop();
            }
            if (!stack.isEmpty()) {
                PSE[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            pre[i] = (i - PSE[i]) * heights[i];
            pre[i] += PSE[i] != -1 ? pre[PSE[i]] : 0;
        }
        for (int i = 0; i < n; i++) {
            sum += pre[i];
        }
        return sum;
    }
}