// Last updated: 4/29/2026, 2:20:33 AM
class Solution {
	public long maximumScore(int[][] grid) {
		int n = grid.length;
		long[] dp1 = new long[n];
		long[] dp2 = new long[n];
		long res = 0, prev1 = 0, prev2 = 0;
        int i = 0;
		while (i < n - 1) {
			long curr = score(grid, dp1, i, prev1, 0, 1, n);
			prev1 = Math.max(res, prev2);
			prev2 = score(grid, dp2, i + 1, res, n - 1, -1, -1);
		    res = Math.max(prev1, curr);
            i++;
		}
		return Math.max(res, prev2);
	}
    long score(int[][] grid, long[] dp, int col, long prev, int row, int dir, int stop) {
		long max = 0;
		while (row != stop) {
            max = Math.max(max, prev);
			prev = dp[row];
            max += grid[row][col];
			dp[row] = max;
            row += dir;
		}
		return max;
	}
}