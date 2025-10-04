// Last updated: 10/4/2025, 6:17:52 AM
class Solution {
    public boolean canAliceWin(int[] nums) {
        int sumSingleDigit = 0;
        int sumDoubleDigit = 0;

        for (int num : nums) {
            if (num < 10) {
                sumSingleDigit += num;
            } else {
                sumDoubleDigit += num;
            }
        }

        if (sumSingleDigit > sumDoubleDigit) {
            return true;
        }

        if (sumDoubleDigit > sumSingleDigit) {
            return true;
        }
        
        return false;
    }
}