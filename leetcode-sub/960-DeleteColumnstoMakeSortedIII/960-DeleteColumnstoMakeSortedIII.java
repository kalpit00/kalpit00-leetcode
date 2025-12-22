// Last updated: 12/21/2025, 9:31:59 PM
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int n = strs[0].length();
4        Integer[][] dp = new Integer[n][n + 1];
5        return solve(0, -1, n, strs, dp);
6    }
7    private int solve(int i, int prev, int n, String[] strs, Integer[][] dp) {
8        if (i >= n) {
9            return 0;
10        }
11        if (dp[i][prev + 1] != null) {
12            return dp[i][prev + 1];
13        }
14        int take = Integer.MAX_VALUE;
15        if (prev == -1 || helper(i, prev, strs)) {
16            take = solve(i + 1, i, n, strs, dp);
17        }
18        int notTake = 1 + solve(i + 1, prev, n, strs, dp);
19        int min = Math.min(take, notTake);
20        if (prev == -1) {
21            return min;
22        }
23        return dp[i][prev + 1] = min;
24    }
25    private boolean helper(int j, int prev, String[] strs) {
26        for (int i = 0; i < strs.length; i++) {
27            if (strs[i].charAt(j) < strs[i].charAt(prev)) {
28                return false;
29            }
30        }
31        return true;
32    }
33}