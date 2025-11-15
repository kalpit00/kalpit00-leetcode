// Last updated: 11/14/2025, 7:59:42 PM
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for (int i = n; i > 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = (arr[i - 1] == arr[j - 1]) ? 
                dp[i + 1][j - 1] + 2 : Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[1][n];
    }
}