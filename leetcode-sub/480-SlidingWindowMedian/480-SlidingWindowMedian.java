// Last updated: 6/8/2025, 4:19:59 AM
class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        Arrays.sort(nums);
        for (int i = 0; i <= n / 2; i++) {
            count += Math.max(0, nums[i] - k);
        }
        for (int i = n / 2; i < n; i++) {
            count += Math.max(0, -nums[i] + k);
        }
        return count;
    }
}