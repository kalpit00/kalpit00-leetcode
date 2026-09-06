// Last updated: 9/5/2026, 9:03:19 PM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int m = s.length(), n = t.length();
4        Integer[][] dp = new Integer[m][n];
5        return solve(s.toCharArray(), t.toCharArray(), 0, 0, m, n, dp);
6    }
7    private int solve(char[] arr1, char[] arr2, int i, int j, int m, int n, Integer[][] dp) {
8        if (j >= n) {
9            return 1;
10        }
11        if (i >= m) {
12            return 0;
13        }
14        if (dp[i][j] != null) {
15            return dp[i][j];
16        }
17        int pick = solve(arr1, arr2, i + 1, j + 1, m, n, dp);
18        int notPick = solve(arr1, arr2, i + 1, j, m, n, dp);
19        return dp[i][j] = (arr1[i] == arr2[j]) ? pick + notPick : notPick;
20    }
21}