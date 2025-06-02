// Last updated: 6/1/2025, 8:50:02 PM
class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        Integer[][][] dp = new Integer[m][n][3]; // memoization table
        return dfs(0, 0, m, n, 0, coins, dp);
    }

    private int dfs(int r, int c, int m, int n, int count,
    int[][] coins, Integer[][][] dp) {
        if (r >= m || c >= n) {
            return Integer.MIN_VALUE;
        }
        if (dp[r][c][count] != null) {
            return dp[r][c][count];
        } 
        int val = coins[r][c];
        if (r == m - 1 && c == n - 1) {
            if (val >= 0) return val;
            return (count < 2) ? 0 : val;
        }
        int right = dfs(r, c + 1, m, n, count, coins, dp);
        int down = dfs(r + 1, c, m, n, count, coins, dp);
        int notTake = val + Math.max(right, down);
        int take = Integer.MIN_VALUE;
        if (val < 0 && count < 2) {
            take = Math.max(dfs(r, c + 1, m, n, count + 1, coins, dp), dfs(r + 1, c, m, n, count + 1, coins, dp));
        }
        return dp[r][c][count] = Math.max(take, notTake);
    }
}
