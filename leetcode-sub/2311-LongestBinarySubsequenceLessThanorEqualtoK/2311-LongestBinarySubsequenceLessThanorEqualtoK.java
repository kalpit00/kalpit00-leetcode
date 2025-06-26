// Last updated: 6/25/2025, 8:31:10 PM
class Solution {
    // Take all zeros and as many ones as possible from right to left.
    public int longestSubsequence(String s, int k) {
        int sum = 0, numOfOnes = 0, numOfZeros = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                numOfZeros++;
            } else {
                sum += Math.pow(2, s.length() - 1 - i);
                if (sum <= k) {
                    numOfOnes++;
                }
            }
        }
        return numOfOnes + numOfZeros;
    }
}