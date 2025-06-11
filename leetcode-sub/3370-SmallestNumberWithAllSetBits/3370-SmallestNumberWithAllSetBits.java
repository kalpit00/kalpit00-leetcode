// Last updated: 6/11/2025, 6:58:20 PM
class Solution {
    public int smallestNumber(int n) {
        return -1 >>> Integer.numberOfLeadingZeros(n);
    }
}