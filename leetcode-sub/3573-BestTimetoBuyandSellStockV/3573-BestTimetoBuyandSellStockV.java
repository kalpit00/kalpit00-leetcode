// Last updated: 12/16/2025, 8:20:51 PM
1class Solution {
2    public long maximumProfit(int[] prices, int k) {
3        int n = prices.length;
4        Long memo[][][] = new Long[n][k + 1][3];
5        return solve(n, 0, k, 0, prices, memo);
6    }
7
8    public long solve(int n, int idx, int k, int id, int[] prices, 
9    Long[][][] memo) {
10        if (idx >= n) {
11            return id == 0 ? 0 : Integer.MIN_VALUE;
12        }
13        if (k < 0) {
14            return Integer.MIN_VALUE;
15        }
16        if (memo[idx][k][id] != null) {
17            return memo[idx][k][id];
18        }
19        
20        if (id == 1) {
21            long sell = solve(n, idx + 1, k, 0, prices, memo) + prices[idx];
22            long hold = solve(n, idx + 1, k, id, prices, memo);
23            memo[idx][k][id] = Math.max(sell, hold);
24        }
25        else if (id == 2) {
26            long buy = solve(n, idx + 1, k, 0, prices, memo) - prices[idx];
27            long skip = solve(n, idx + 1, k, id, prices, memo);
28            memo[idx][k][id] = Math.max(buy, skip);
29        }
30        else { 
31            long sell = solve(n, idx + 1, k - 1, 2, prices, memo) + prices[idx];
32            long buy = solve(n, idx + 1, k - 1, 1, prices, memo) - prices[idx];
33            long skip = solve(n, idx + 1, k, 0, prices, memo);
34            memo[idx][k][id] = Math.max(Math.max(sell, buy), skip);			
35        }
36        return memo[idx][k][id];
37    }
38}