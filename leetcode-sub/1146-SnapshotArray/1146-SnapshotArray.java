// Last updated: 8/23/2025, 12:27:55 AM
class Solution {
    public int sortPermutation(int[] nums) {
        int mask = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) mask &= nums[i];
        }
        return mask == Integer.MAX_VALUE ? 0 : mask;
    }
}