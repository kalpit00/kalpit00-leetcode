// Last updated: 4/11/2025, 6:55:15 PM
class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            count += 2 * (nums[i - 1] + nums[i + 1]) == nums[i] ? 1 : 0;
        }
        return count;
    }
}