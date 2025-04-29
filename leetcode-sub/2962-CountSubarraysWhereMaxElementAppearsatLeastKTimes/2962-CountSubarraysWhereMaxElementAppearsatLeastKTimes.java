// Last updated: 4/28/2025, 8:13:33 PM
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length, max = 0, left = 0, right = 0, counter = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        long count = 0;
        while (right < n) {
            if (nums[right] == max) {
                counter++;
            }
            right++;
            while (counter >= k) {
                if (nums[left] == max) {
                    counter--;
                }
                left++;
            }
            count += right - left;
        }
        return (long) n * (n + 1) / 2 - count;
    }
}
