// Last updated: 8/23/2025, 12:26:56 AM
class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length, k = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                k = k == -1 ? nums[i] : k;
                k &= nums[i];
            }
        }
        return k == -1 ? 0 : k;
    }
}