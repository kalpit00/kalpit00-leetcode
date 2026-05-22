// Last updated: 5/22/2026, 1:22:29 AM
1class Solution {
2    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
3        int n = piles.size();
4        Long[][] dp = new Long[n + 1][k + 1];
5        return (int) solve(0, n, k, piles, dp);
6    }
7    private long solve(int i, int n, int k, List<List<Integer>> piles, 
8    Long[][] dp) {
9        if (i >= n) {
10            return 0;
11        }
12        if (dp[i][k] != null) {
13            return dp[i][k];
14        }
15        long max = 0, sum = 0;
16        long notTake = solve(i + 1, n, k, piles, dp);
17        max = Math.max(max, notTake);
18        for (int j = 0; j < piles.get(i).size(); j++) {
19            sum += piles.get(i).get(j);
20            if (k >= j + 1) {
21                long take = sum + solve(i + 1, n, k - j - 1, piles, dp);
22                max = Math.max(max, take);
23            }
24        }
25        return dp[i][k] = max;
26    }
27}