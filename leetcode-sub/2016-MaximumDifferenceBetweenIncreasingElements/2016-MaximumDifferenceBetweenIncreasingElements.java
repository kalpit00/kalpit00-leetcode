// Last updated: 6/15/2025, 8:33:24 PM
class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length, max = -1, min = nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
            if (min < nums[i]) {
                max = Math.max(max, nums[i] - min);
            }
        }
        return max;
    }
}