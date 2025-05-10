// Last updated: 5/10/2025, 3:46:25 AM
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int left = 0, right = 0, max = -1, min = -1, n = nums.length;
        while (right < n) {
            if (nums[right] < minK || nums[right] > maxK) {
                left = right + 1;
            }
            if (nums[right] == minK) {
                min = right;
            }
            if (nums[right] == maxK) {
                max = right;
            }
            count += Math.max(0, Math.min(max, min) - left + 1);
            right++;
        }
        return count;
    }
}