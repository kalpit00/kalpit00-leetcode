// Last updated: 6/1/2026, 12:07:43 AM
1class Solution {
2    public int minimumCost(int[] cost) {
3        Arrays.sort(cost);
4        int sum = 0, n = cost.length;
5        for (int i = 0; i < n; i++) {
6            sum += i % 3 != n % 3 ? cost[i] : 0;
7        }
8        return sum;
9    }
10}