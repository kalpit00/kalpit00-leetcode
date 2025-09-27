// Last updated: 9/26/2025, 10:56:50 PM
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
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
            nums[i] = 1 - nums[i];
            nums[n - i - 1] = 1 - nums[n - i - 1];
        }
        if (n % 2 == 1) {
            nums[n / 2] = 1 - nums[n / 2];
        }
    }
}