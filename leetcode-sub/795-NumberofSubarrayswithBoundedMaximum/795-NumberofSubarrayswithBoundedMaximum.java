// Last updated: 6/6/2025, 1:32:38 AM
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return helper(nums, right) - helper(nums, left - 1);
    }
    private int helper(int[] nums, int bound) {
        int sum = 0, count = 0;
        for (int num : nums) {
            count = num <= bound ? count + 1 : 0;
            sum += count;
        }
        return sum;
    }
}