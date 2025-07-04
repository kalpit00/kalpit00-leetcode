// Last updated: 7/3/2025, 8:07:30 PM
class Solution {

    public char kthCharacter(long k, int[] operations) {
        int ans = 0;
        k--;
        for (int i = 63 - Long.numberOfLeadingZeros(k); i >= 0; i--) {
            if (((k >> i) & 1) == 1) {
                ans += operations[i];
            }
        }
        return (char) ('a' + (ans % 26));
    }
}