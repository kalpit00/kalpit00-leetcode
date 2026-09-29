// Last updated: 9/29/2026, 4:13:49 AM
1class Solution {
2    public boolean hasValidPath(char[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        Boolean[][][] dp = new Boolean[m][n][m + n + 1];
5        return solve(grid, dp, 0, 0, 0, m, n);
6    }
7    private boolean solve(char[][] grid, Boolean[][][] dp, int i, int j, int balance, int m, int n) {
8        if (balance < 0) return false;
9        if (i == m || j == n) return false;
10        if (i == m - 1 && j == n - 1 && grid[i][j] == ')' && balance == 1)  {
11            return true;
12        }
13        if (i == m - 1 && j == n - 1) return false;
14        if (dp[i][j][balance] != null) return dp[i][j][balance];
15        int newBalance = balance + (grid[i][j] == '(' ? 1 : -1);
16        return dp[i][j][balance] = solve(grid, dp, i + 1, j, newBalance, m, n) || solve(grid, dp, i, j + 1, newBalance, m, n);
17    }
18}