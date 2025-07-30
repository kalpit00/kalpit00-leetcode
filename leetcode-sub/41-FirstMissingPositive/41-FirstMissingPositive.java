// Last updated: 7/30/2025, 6:01:13 PM
class Solution {
    public int firstMissingPositive(int[] nums) {
        cycleSort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    private void cycleSort(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n) {
            if (nums[i] <= 0 || nums[i] >= n || nums[i] == nums[nums[i] - 1]) {
                i++;
            } // repeatedly check if nums[i] is on the index : nums[i] - 1
            else {
                swap(nums, i, nums[i] - 1);
            } // if not, swap to place [1] on idx 0, [2] on idx 1, and so on ..
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}