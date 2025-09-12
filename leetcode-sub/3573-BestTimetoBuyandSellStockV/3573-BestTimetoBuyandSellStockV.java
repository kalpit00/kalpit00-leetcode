// Last updated: 9/12/2025, 1:21:02 AM
class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        Long memo[][][] = new Long[n][k + 1][3];
        return solve(n, 0, k, 0, prices, memo);
    }

    public long solve(int n, int idx, int k, int id, int[] prices, 
    Long[][][] memo) {
        if (idx >= n) {
            return id == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (k < 0) {
            return Integer.MIN_VALUE;
        }
        if (memo[idx][k][id] != null) {
            return memo[idx][k][id];
        }
        
        if (id == 1) {
            long sell = solve(n, idx + 1, k, 0, prices, memo) + prices[idx];
            long hold = solve(n, idx + 1, k, id, prices, memo);
            memo[idx][k][id] = Math.max(sell, hold);
        }
        else if (id == 2) {
            long buy = solve(n, idx + 1, k, 0, prices, memo) - prices[idx];
            long skip = solve(n, idx + 1, k, id, prices, memo);
            memo[idx][k][id] = Math.max(buy, skip);
        }
        else { 
            long sell = solve(n, idx + 1, k - 1, 2, prices, memo) + prices[idx];
            long buy = solve(n, idx + 1, k - 1, 1, prices, memo) - prices[idx];
            long skip = solve(n, idx + 1, k, 0, prices, memo);
            memo[idx][k][id] = Math.max(Math.max(sell, buy), skip);			
        }
        return memo[idx][k][id];
    }
}