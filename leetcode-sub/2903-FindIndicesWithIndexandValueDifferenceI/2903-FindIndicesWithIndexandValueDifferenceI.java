// Last updated: 6/20/2025, 1:29:42 AM
class Solution {
    public int[] findIndices(int[] nums, int a, int b) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) >= a && Math.abs(nums[i] - nums[j]) >= b) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}