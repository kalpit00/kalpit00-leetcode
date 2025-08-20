// Last updated: 8/20/2025, 3:06:12 AM
class Solution {
    public int numberOfSteps(int num) {
        return num == 0 ? 0 : 
        31 - Integer.numberOfLeadingZeros(num) + Integer.bitCount(num);
    }
}