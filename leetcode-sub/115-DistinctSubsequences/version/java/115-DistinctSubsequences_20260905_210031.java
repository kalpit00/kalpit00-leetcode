// Last updated: 9/5/2026, 9:00:31 PM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int m = s.length(), n = t.length();
4        char[] arr1 = s.toCharArray(), arr2 = t.toCharArray();
5        int[] dp = new int[n+1];
6        dp[0] = 1;
7        for (int i = 1; i <= m; i++) {
8            for (int j = n; j >= 1; j--) {
9                dp[j] = (arr1[i - 1] == arr2[j - 1]) ?
10                dp[j - 1] + dp[j] : dp[j]; // if match, pick + notPick, els nPi
11            }
12        }
13        return dp[n];
14    }
15}