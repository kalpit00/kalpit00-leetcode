// Last updated: 4/29/2025, 11:52:34 PM
class Solution {
    public int minOperations(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            int x = 31 - Integer.numberOfLeadingZeros(n); // logN
            int prev = 1 << x, next = 1 << (x + 1); // [2^x .. n .. 2^(x + 1)]
            n = Math.min(n - prev, next - n);
        } // move 'n' to the closest power of 2
        return count;
    }
}