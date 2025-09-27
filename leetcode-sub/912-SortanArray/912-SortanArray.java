// Last updated: 9/26/2025, 8:48:14 PM
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        return nums;
    }
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivotIndex = hoarePartition(nums, start, end);
        quickSort(nums, start, pivotIndex);
        quickSort(nums, pivotIndex + 1, end);
    }

    private int hoarePartition(int[] nums, int start, int end) {
        int pivot = nums[start], i = start - 1, j = end + 1;
        while (true) {
            do { i++; } while (nums[i] < pivot);
            do { j--; } while (nums[j] > pivot);
            if (i >= j) return j;
            swap(nums, i, j);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
