// Last updated: 8/14/2025, 8:11:28 PM
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false; 
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}