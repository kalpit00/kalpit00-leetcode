// Last updated: 1/9/2026, 8:26:05 PM
1class Solution {
2    public int minimumDeleteSum(String s1, String s2) {
3        int lcs = lcs(s1, s2), m = s1.length(), n = s2.length(), a = 0, b = 0;
4        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
5        for (int i = 0; i < m; i++) {
6            a += (int) arr1[i];
7        }
8        for (int i = 0; i < n; i++) {
9            b += (int) arr2[i];
10        }
11        return a + b - 2*lcs;
12    }
13    public int lcs(String text1, String text2) {
14        int m = text1.length(), n = text2.length();
15        char[] arr1 = text1.toCharArray(), arr2 = text2.toCharArray();
16        int[][] dp = new int[m+1][n+1];
17        for (int i = 1; i <= m; i++) {
18            for (int j = 1; j <= n; j++) {
19                dp[i][j] = (arr1[i - 1] == arr2[j - 1]) ? 
20                dp[i - 1][j - 1] + (int) arr1[i - 1] : 
21                Math.max(dp[i - 1][j], dp[i][j - 1]);
22            }
23        }
24        return dp[m][n];
25    }
26}