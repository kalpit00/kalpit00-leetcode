// Last updated: 4/26/2025, 9:29:58 PM
class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            count += 2 * (nums[i - 1] + nums[i + 1]) == nums[i] ? 1 : 0;
        }
        return count;
    }
}