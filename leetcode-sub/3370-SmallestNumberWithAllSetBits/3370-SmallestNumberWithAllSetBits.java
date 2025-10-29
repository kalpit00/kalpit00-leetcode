// Last updated: 10/28/2025, 9:06:57 PM
class Solution {
    public int smallestNumber(int n) {
        return -1 >>> Integer.numberOfLeadingZeros(n);
    }
}