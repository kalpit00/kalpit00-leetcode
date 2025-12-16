// Last updated: 12/16/2025, 3:45:52 AM
1class Solution {
2    public String shortestCommonSupersequence(String s, String t) {
3        int m = s.length(), n = t.length();
4        char[] arr1 = s.toCharArray(), arr2 = t.toCharArray();
5        int[][] dp = lcs(s, t);
6        int lcs = dp[m][n];
7        char[] ans = new char[m + n - lcs];
8        int i = m, j = n, idx = ans.length - 1;
9        while (i > 0 && j > 0) {
10            if (arr1[i - 1] == arr2[j - 1]) {
11                ans[idx--] = arr1[i - 1];
12                i--;
13                j--;
14            }
15            else if (dp[i - 1][j] > dp[i][j - 1]) {
16                ans[idx--] = arr1[i - 1];
17                i--;
18            }
19            else {
20                ans[idx--] = arr2[j - 1];
21                j--;
22            }
23        }
24        while (i > 0) {
25            ans[idx--] = arr1[i - 1];
26            i--;
27        }
28        while (j > 0) {
29            ans[idx--] = arr2[j - 1];
30            j--;
31        }
32        return new String(ans);
33    }
34    public int[][] lcs(String text1, String text2) {
35        int m = text1.length(), n = text2.length();
36        char[] arr1 = text1.toCharArray(), arr2 = text2.toCharArray();
37        int[][] dp = new int[m+1][n+1];
38        for (int i = 1; i <= m; i++) {
39            for (int j = 1; j <= n; j++) {
40                dp[i][j] = (arr1[i - 1] == arr2[j - 1]) ? 
41                dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
42            }
43        }
44        return dp;
45    }
46}