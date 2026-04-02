// Last updated: 4/1/2026, 8:27:07 PM
1class Solution {
2    public int maximumAmount(int[][] coins) {
3        int m = coins.length, n = coins[0].length;
4        Integer[][][] dp = new Integer[m][n][3]; // memoization table
5        return dfs(0, 0, m, n, 0, coins, dp);
6    }
7
8    private int dfs(int r, int c, int m, int n, int count,
9    int[][] coins, Integer[][][] dp) {
10        if (r >= m || c >= n) {
11            return Integer.MIN_VALUE;
12        }
13        if (dp[r][c][count] != null) {
14            return dp[r][c][count];
15        } 
16        int val = coins[r][c];
17        if (r == m - 1 && c == n - 1) {
18            if (val >= 0) return val;
19            return (count < 2) ? 0 : val;
20        }
21        int right = dfs(r, c + 1, m, n, count, coins, dp);
22        int down = dfs(r + 1, c, m, n, count, coins, dp);
23        int notTake = val + Math.max(right, down);
24        int take = Integer.MIN_VALUE;
25        if (val < 0 && count < 2) {
26            take = Math.max(dfs(r, c + 1, m, n, count + 1, coins, dp), dfs(r + 1, c, m, n, count + 1, coins, dp));
27        }
28        return dp[r][c][count] = Math.max(take, notTake);
29    }
30}
31