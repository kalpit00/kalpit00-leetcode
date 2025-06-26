// Last updated: 6/25/2025, 8:28:55 PM
class Solution {
    public int longestSubsequence(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length, count = 0, pow = 1, val = 0;
        for (int i = n - 1; i >= 0 && val + pow <= k; i--) {
            if (arr[i] == '1') {
                count++;
                val += pow;
            }
            pow <<= 1;
        }
        for (int c : arr) {
            count += c == '0' ? 1 : 0;
        }
        return count;
    }
}