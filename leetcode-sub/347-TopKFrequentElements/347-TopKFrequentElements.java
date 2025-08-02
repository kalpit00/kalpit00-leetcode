// Last updated: 8/2/2025, 2:24:25 PM
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int n = max - min + 1;
        int[][] freq = new int[n][2];
        for (int num : nums) {
            freq[num - min][0] = num;
            freq[num - min][1]++;
        }
        quickSelect(freq, 0, n - 1, n - k);
        for (int i = 0; i < k; i++) {
            res[i] = freq[n - i - 1][0];
        }
        return res;
    }
    private int quickSelect(int[][] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start][1];
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
            return nums[k][1];
        }
    }
    // Dutch National Flag Algorithm
    private int[] partition(int[][] nums, int start, int end, int pivotIndex) {
        int pivot = nums[pivotIndex][1]; 
        int i = start, idx = start, j = end;
        while (idx <= j && i < j) {
            if (nums[idx][1] < pivot) {
                swap(nums, i++, idx++);
            }
            else if (nums[idx][1] > pivot) {
                swap(nums, j--, idx);
            }
            else {
                idx++;
            }
        }
        return new int[]{i, j};
    }
    private void swap(int[][] nums, int i, int j) {
        int[] temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}