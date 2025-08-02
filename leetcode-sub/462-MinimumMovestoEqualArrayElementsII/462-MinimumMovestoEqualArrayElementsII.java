// Last updated: 8/1/2025, 11:39:17 PM
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, sum = 0;
        int median = quickSelect(nums, 0, n - 1, (n - 1) / 2);        
        for (int num : nums) {
            sum += Math.abs(median - num);
        }
        return sum;
    }
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        } // take random pivot choice between index [start .. end]
        int pivotIndex = start + new Random().nextInt(end - start + 1);
        int pivot[] = partition(nums, start, end, pivotIndex);
        if (pivot[0] > k) {
            return quickSelect(nums, start, pivot[0] - 1, k);
        }
        else if (pivot[1] < k) {
            return quickSelect(nums, pivot[1] + 1, end, k);
        }
        else {
            return nums[k];
        }
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