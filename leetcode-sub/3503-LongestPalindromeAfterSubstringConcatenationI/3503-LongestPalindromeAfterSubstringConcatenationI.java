// Last updated: 8/14/2025, 8:16:57 PM
class Solution {
    public int longestPalindrome(String s, String t) {
        String rev = new StringBuilder(t).reverse().toString();
        char[] arr1 = s.toCharArray(), arr2 = rev.toCharArray();
        int m = arr1.length, n = arr2.length, max = 0;
        int[] p1 = manacher(convert(s), m), p2 = manacher(convert(rev), n);
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (arr1[i - 1] == arr2[j - 1]) ? 
                dp[i - 1][j - 1] + 1 : 0;
                int sum = 2 * dp[i][j] + Math.max(p1[i], p2[j]);
                max = Math.max(sum, max);
            }
        }        
        for (int i = 0; i <= m; i++) {
            max = Math.max(max, p1[i]);
        }
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, p2[i]);
        }
        return max;
    } 
    private char[] convert(String s) {
        int n = s.length() * 2 + 3;
        char[] arr = new char[n];
        int idx = 0;
        arr[idx++] = '@';
        arr[idx++] = '#';
        for (char c : s.toCharArray()) {
            arr[idx++] = c;
            arr[idx++] = '#';
        }
        arr[n - 1] = '$';
        return arr;
    }

    private int[] manacher(char[] arr, int m) {
        int n = arr.length;
        int[] p = new int[n], res = new int[m + 1];
        int center = 0, maxRight = 0;
        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;
            if (i < maxRight) {
                p[i] = Math.min(maxRight - i, p[mirror]);
            }
            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n &&
                   arr[i - p[i] - 1] == arr[i + p[i] + 1]) {
                p[i]++;
            }
            if (i + p[i] > maxRight) {
                center = i;
                maxRight = i + p[i];
            }
            int start = (i - p[i] - 1) / 2;
            res[start] = p[i];
        }
        return res;
    } // res[i] = length of longest palindrome STARTING at 'i'
}