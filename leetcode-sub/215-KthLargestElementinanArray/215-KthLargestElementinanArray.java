// Last updated: 8/1/2025, 7:10:56 PM
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    } // [n - k]th smallest = k'th largest

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        } // take random pivot choice between index [start .. end]
        int pivotIndex = start + new Random().nextInt(end - start + 1);
        int pivot = partition(nums, start, end, pivotIndex);
        if (pivot == k) {
            return nums[k];
        }
        else if (pivot > k) {
            return quickSelect(nums, start, pivot - 1, k);
        }
        else {
            return quickSelect(nums, pivot + 1, end, k);
        }
    }
    private int partition(int[] nums, int start, int end, int pivotIndex) {
        int pivot = nums[pivotIndex]; 
        swap(nums, pivotIndex, end); // temporarily put pivot on end
        int j = start;
        for (int i = start; i < end; i++) { // nums[start ... end]
            if (nums[i] < pivot) {
                swap(nums, i, j++);
            } // place all elements < pivot in front, in [start .. j .. end]
        } // [start .. j] now has all nums < pivot
        swap(nums, j, end); // move pivot just AFTER the 'j'th pos
        return j;
    } // return 'j' which is summing elements < k, thereby O(N) sort
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}