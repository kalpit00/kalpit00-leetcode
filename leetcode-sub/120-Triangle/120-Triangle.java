// Last updated: 9/24/2025, 8:13:18 PM
class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int n = list.size();
        int[][] matrix = new int[n][];
        Integer[][] memo = new Integer[n][];
        for (int i = 0; i < n; i++) {
            int cols = i + 1;
            matrix[i] = new int[cols];
            memo[i] = new Integer[cols];
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = list.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, solve(n - 1, j, matrix, memo));
        }
        return min;
    }
    private int solve(int i, int j, int[][] matrix, Integer[][] memo) {
        if (i == 0) {
            return matrix[i][j];
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int left = (j > 0) ? solve(i - 1, j - 1, matrix, memo) : Integer.MAX_VALUE;
        int right = (j < i) ? solve(i - 1, j, matrix, memo) : Integer.MAX_VALUE;
        return memo[i][j] = matrix[i][j] + Math.min(left, right);
    }
}
