// Last updated: 5/13/2025, 8:51:53 PM
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] p = manacher(convert(s));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1; // dp[i] = the min number of cuts for prefix s[0..i-1]
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) { // if s[j .. i] is pali, cut
                if (isPalindrome(j, i - 1, p)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                } // LIS DP touch! For each i, look back at all j < i.
            } // If s[j..i-1] is a pali, make a cut (+1) and min dp[j]
        } 
        return dp[n]; // dp[n] gives min no of cuts for entire string 's'
    }
    private char[] convert(String s) { // pad 's' for manachers odd/even str
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
    private int[] manacher(char[] arr) {
        int n = arr.length;
        int[] p = new int[n];
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
        }
        return p;
    } // Check if s[i..j] is a palindrome using manacher's p[]
    private boolean isPalindrome(int i, int j, int[] p) {
        int left = 2 * i + 2, right = 2 * j + 2; // 2x + 2 as manacher padding
        int center = (left + right) / 2; // [left .... center .... right]
        return p[center] >= (right - left) / 2;
    } // p[i] gives radius of how many chars match on 'both' sides from 'i'
} // right - left is total dist between the 2 ptrs, half of it is distance from the 'center'. If p[center] is >= this, s[i..j] is a palindrome!
