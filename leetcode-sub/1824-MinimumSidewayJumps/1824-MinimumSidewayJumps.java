// Last updated: 10/2/2025, 8:54:23 PM
class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        for (int i = 1; i < n - 1; i++) {
            int max = Math.max(nums[i], Math.max(nums[i - 1], nums[i + 1]));
            if (max < k) {
                nums[i - 1] += k - max;
                nums[i - 1] += k - max;
                nums[i] += k - max;
                nums[i + 1] += k - max;
                count += (long) (k - max);
            }
        }
        return count;
    }
}