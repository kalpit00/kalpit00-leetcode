// Last updated: 4/29/2025, 8:46:06 PM
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            count += ((int) (Math.log10(num)) + 1) % 2 == 0 ? 1 : 0;
        }
        return count;
    }
}