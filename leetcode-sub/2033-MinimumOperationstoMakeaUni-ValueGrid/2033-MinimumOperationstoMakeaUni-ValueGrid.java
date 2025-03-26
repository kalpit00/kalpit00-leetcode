// Last updated: 3/25/2025, 9:33:08 PM
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length, k = m * n, count = 0, 
        min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, idx = 0;
        int[] nums = new int[k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[idx++] = grid[i][j];
                min = Math.min(min, grid[i][j]);
                max = Math.max(max, grid[i][j]);
            }
        }
        bucketSort(nums, min, max);
        int median = nums[k / 2];
        for (int num : nums) {
            if (num % x != median % x) {
                return -1;
            }
            count += Math.abs(median - num) / x;
        }
        return count;
    }
    public void bucketSort(int[] nums, int min, int max) {
        int size = max - min + 1;
        int[] buckets = new int[size];
        for (int num : nums) {
            buckets[num - min]++;
        }
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                nums[index++] = i + min;
            }
        }
    }
}