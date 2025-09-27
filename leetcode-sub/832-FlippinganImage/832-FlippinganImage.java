// Last updated: 9/26/2025, 10:59:03 PM
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            helper(image[i]);
        }
        return image;
    }
    private void helper(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            swap(nums, i, n - i - 1);
            nums[i] = 1 - nums[i];
            nums[n - i - 1] = 1 - nums[n - i - 1];
        }
        nums[n / 2] = n % 2 == 1 ? 1 - nums[n / 2] : nums[n / 2];
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}