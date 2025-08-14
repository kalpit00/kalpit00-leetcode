// Last updated: 8/14/2025, 6:42:55 PM
class Solution {
    public int longestPalindromeSubseq(String s) {
        return lcs(s, new StringBuilder(s).reverse().toString());
    }
    public int lcs(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        char[] arr1 = text1.toCharArray(), arr2 = text2.toCharArray();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (arr1[i - 1] == arr2[j - 1]) ? 
                dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}