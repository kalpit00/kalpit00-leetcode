// Last updated: 6/20/2025, 1:44:21 AM
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int min = 0, max = 0, n = nums.length, i = indexDifference, j = 0;
        while (i < n) {
            min = nums[min] < nums[j] ? min : j;
            max = nums[max] > nums[j] ? max : j;
            if (Math.abs(nums[i] - nums[min]) >= valueDifference) {
                return new int[] {min, i};
            }
            if (Math.abs(nums[i] - nums[max]) >= valueDifference) {
                return new int[] {max, i};
            }
            i++;
            j++;
        }
        return new int[]{-1, -1};
    }
}