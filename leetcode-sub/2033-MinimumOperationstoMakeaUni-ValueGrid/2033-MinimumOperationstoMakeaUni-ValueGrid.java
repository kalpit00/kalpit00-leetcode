// Last updated: 3/25/2025, 9:03:20 PM
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length, k = m * n, idx = 0, count = 0;
        int[] nums = new int[k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % x != grid[0][0] % x) {
                    return -1;
                }
                nums[idx++] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        int median = nums[k / 2];
        for (int num : nums) {
            if (num % x != median % x) {
                return -1;
            }
            count += Math.abs(median - num) / x;
        }
        return count;
    }
}