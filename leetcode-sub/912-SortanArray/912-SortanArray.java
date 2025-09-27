// Last updated: 9/27/2025, 4:35:38 AM
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        } // O(N) build maxHeap BOTTOM UP!!
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        } // O(NLogN) times heapifies
        return nums;
    }

    private void heapify(int[] nums, int heapSize, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, heapSize, largest);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
