// Last updated: 8/1/2025, 11:19:11 PM
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] nums = new int[n][3], res = new int[k][2];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1], val = x * x + y * y;
            nums[i] = new int[]{x, y, val};
        }
        quickSelect(nums, 0, n - 1, k - 1);
        for (int i = 0; i < k; i++) {
            res[i] = new int[]{nums[i][0], nums[i][1]};
        }
        return res;
    }
    private int quickSelect(int[][] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start][2];
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
            return nums[k][2];
        }
    }
    // Dutch National Flag Algorithm
    private int[] partition(int[][] nums, int start, int end, int pivotIndex) {
        int pivot = nums[pivotIndex][2]; 
        int i = start, idx = start, j = end;
        while (idx <= j && i < j) {
            if (nums[idx][2] < pivot) {
                swap(nums, i++, idx++);
            }
            else if (nums[idx][2] > pivot) {
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