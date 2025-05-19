// Last updated: 5/19/2025, 1:05:27 AM
class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0, max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, (sum + i) / (i + 1));
        }
        return (int) max;
    }
}