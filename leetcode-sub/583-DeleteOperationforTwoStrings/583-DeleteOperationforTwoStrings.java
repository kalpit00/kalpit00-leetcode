// Last updated: 1/9/2026, 8:32:30 PM
1
2class Solution {
3    public int minDistance(String s1, String s2) {
4        int lcs = lcs(s1, s2), a = s1.length(), b = s2.length();
5        return a + b - 2*lcs;
6    }
7    public int lcs(String text1, String text2) {
8        int m = text1.length(), n = text2.length();
9        char[] arr1 = text1.toCharArray(), arr2 = text2.toCharArray();
10        int[][] dp = new int[m+1][n+1];
11        for (int i = 1; i <= m; i++) {
12            for (int j = 1; j <= n; j++) {
13                dp[i][j] = (arr1[i - 1] == arr2[j - 1]) ? 
14                dp[i - 1][j - 1] + 1 : 
15                Math.max(dp[i - 1][j], dp[i][j - 1]);
16            }
17        }
18        return dp[m][n];
19    }
20}