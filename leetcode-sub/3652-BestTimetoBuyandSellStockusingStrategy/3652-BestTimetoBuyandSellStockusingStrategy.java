// Last updated: 12/18/2025, 2:38:37 PM
1class Solution {
2
3    public long maxProfit(int[] prices, int[] strategy, int k) {
4        int n = prices.length;
5        long[] profitSum = new long[n + 1];
6        long[] priceSum = new long[n + 1];
7        for (int i = 0; i < n; i++) {
8            profitSum[i + 1] = profitSum[i] + (long) prices[i] * strategy[i];
9            priceSum[i + 1] = priceSum[i] + prices[i];
10        }
11        long res = profitSum[n];
12        for (int i = k - 1; i < n; i++) {
13            long leftProfit = profitSum[i - k + 1];
14            long rightProfit = profitSum[n] - profitSum[i + 1];
15            long changeProfit = priceSum[i + 1] - priceSum[i - k / 2 + 1];
16            res = Math.max(res, leftProfit + changeProfit + rightProfit);
17        }
18        return res;
19    }
20}