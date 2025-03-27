// Last updated: 3/27/2025, 3:06:35 AM
class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length, m = pattern.length, count = 0;
        for (int i = 0; i < n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (pattern[j] == 1) {
                    if (nums[i + j + 1] <= nums[i + j]) {
                        count--;
                        break;
                    }
                }
                else if (pattern[j] == 0) {
                    if (nums[i + j + 1] != nums[i + j]) {
                        count--;
                        break;
                    }
                }
                else if (pattern[j] == -1) {
                    if (nums[i + j + 1] >= nums[i + j]) {
                        count--;
                        break;
                    }
                }
            }
            count++;
        }
        return count;
    }
}