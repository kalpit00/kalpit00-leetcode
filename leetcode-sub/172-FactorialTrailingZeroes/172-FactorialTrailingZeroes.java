// Last updated: 7/17/2025, 12:33:19 PM
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5; 
            n /= 5;        
        }
        return count;
    }
}