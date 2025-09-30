// Last updated: 9/30/2025, 12:14:09 AM
class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;

        while (n > 1) { // keep shrinking until only one number left
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--; // effectively the array shrinks by one
        }

        return nums[0];
    }
}
