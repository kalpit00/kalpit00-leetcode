// Last updated: 8/1/2025, 8:13:45 PM
class Solution {    
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        return nums;
    }
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = start + new Random().nextInt(end - start + 1);
        int[] pivot = partition(nums, start, end, pivotIndex);
        quickSort(nums, start, pivot[0] - 1);
        quickSort(nums, pivot[1] + 1, end);
    }
    // Dutch National Flag Algorithm
    private int[] partition(int[] nums, int start, int end, int pivotIndex) {
        int pivot = nums[pivotIndex]; 
        int i = start, idx = start, j = end;
        while (idx <= j && i < j) {
            if (nums[idx] < pivot) {
                swap(nums, i++, idx++);
            }
            else if (nums[idx] > pivot) {
                swap(nums, j--, idx);
            }
            else {
                idx++;
            }
        }
        return new int[]{i, j};
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
