// Last updated: 8/23/2025, 9:01:03 PM
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, max = 0, count = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }
            right++;
            while (count > 1) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max - 1;
    }
}