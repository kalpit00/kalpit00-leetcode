// Last updated: 4/4/2025, 8:05:20 PM
class Solution {
    public int subsetXORSum(int[] nums) {
        int mask = 0, n = nums.length;
        for (int num : nums) {
            mask |= num;
        }
        return mask << n - 1;
    }
}