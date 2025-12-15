// Last updated: 12/14/2025, 11:07:08 PM
1class Solution {
2    public long getDescentPeriods(int[] prices) {
3        long sum = 1, count = 1;
4        for (int i = 1; i < prices.length; i++) {
5            count = prices[i - 1] == prices[i] + 1 ? count + 1 : 1;
6            sum += count;
7        }
8        return sum;
9    }
10}