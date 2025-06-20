// Last updated: 6/20/2025, 1:47:23 AM
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int minIdx = 0, maxIdx = 0;
        for (int i = indexDifference; i < nums.length; i++) {
            // Update valid min/max, which is based on nums[i - indexDifference]
            if (nums[i - indexDifference] > nums[maxIdx]) {
                maxIdx = i - indexDifference;
            } 
            if (nums[i - indexDifference] < nums[minIdx]) {
                minIdx = i - indexDifference;
            }
            // Check if current number nums[i] and min/max are valid pair
            if (nums[i] >= nums[minIdx] + valueDifference) {
                return new int[] {i, minIdx};
            } 
            if (nums[i] <= nums[maxIdx] - valueDifference) {
                return new int[] {i, maxIdx};
            }
        }

        return new int[] {-1, -1};
    }
}