// Last updated: 5/31/2025, 9:33:18 PM
class Solution {
    public int smallestEqual(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i % 10) {
                return i;
            }
        }
        return -1;
    }
}