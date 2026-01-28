// Last updated: 1/27/2026, 11:24:11 PM
class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length, max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) max = Math.max(max, grid[i][j]); //find max val in grid
        }

        int[][] dp = new int[n][m]; //dp[i][j] = min cost for cell (i, j) to reach cell (m - 1, n - 1)
        int[] temp = new int[max + 1], best = new int[max + 1]; //temp[val] = min cost for a cell with a value of val to reach cell (m - 1, n - 1)
        Arrays.fill(temp, Integer.MAX_VALUE);
        temp[grid[n - 1][m - 1]] = 0;

        for(int i = m - 2; i >= 0; i--) { //handle the bottom row seperately
            dp[n - 1][i] = dp[n - 1][i + 1] + grid[n - 1][i + 1];
            temp[grid[n - 1][i]] = Math.min(temp[grid[n - 1][i]], dp[n - 1][i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = dp[i + 1][m - 1] + grid[i + 1][m - 1]; //handle the right column seperately
            temp[grid[i][m - 1]] = Math.min(temp[grid[i][m - 1]], dp[i][m - 1]);
            for(int j = m - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j] + grid[i + 1][j], dp[i][j + 1] + grid[i][j + 1]); //fill out base table with no teleports
                temp[grid[i][j]] = Math.min(temp[grid[i][j]], dp[i][j]); //update min cost for each grid value
            }
        }

        for(int x = 0; x < k; x++) { //for each possible teleport, dp[i][j] = min cost to go from cell (i, j) to cell (m - 1, n - 1) using at most x teleports
            //cost[i][j] = min(cost[i + 1][j], cost[i][j + 1], best[grid[i][j]])

            best[0] = temp[0];
            for(int i = 1; i <= max; i++) best[i] = Math.min(best[i - 1], temp[i]); //best[val] = min cost for a cell with a value <= val to reach the cell (m - 1, n - 1)
            
            for(int i = m - 2; i >= 0; i--) { //handle the bottom row seperately
                dp[n - 1][i] = Math.min(best[grid[n - 1][i]], dp[n - 1][i + 1] + grid[n - 1][i + 1]);
                temp[grid[n - 1][i]] = Math.min(temp[grid[n - 1][i]], dp[n - 1][i]);
            }
            for(int i = n - 2; i >= 0; i--) {
                dp[i][m - 1] = Math.min(best[grid[i][m - 1]], dp[i + 1][m - 1] + grid[i + 1][m - 1]); //handle the right column seperately
                temp[grid[i][m - 1]] = Math.min(temp[grid[i][m - 1]], dp[i][m - 1]);
                for(int j = m - 2; j >= 0; j--) {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j] + grid[i + 1][j], dp[i][j + 1] + grid[i][j + 1]), best[grid[i][j]]);
                    temp[grid[i][j]] = Math.min(temp[grid[i][j]], dp[i][j]);
                }
            }
        }
        return dp[0][0]; //return final cost to go from cell (0, 0) to cell (m - 1, n - 1) using at most k teleports
    }
}