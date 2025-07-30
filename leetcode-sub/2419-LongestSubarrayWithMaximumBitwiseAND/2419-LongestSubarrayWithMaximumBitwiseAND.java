// Last updated: 7/29/2025, 8:03:46 PM
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE, ans = 1;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                int streak = 1;
                while (i < n - 1 && nums[i + 1] == max) {
                    i++;
                    streak++;
                }
                ans = Math.max(ans, streak);
            }
        }
        return ans;
    }
}