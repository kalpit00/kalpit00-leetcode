// Last updated: 3/25/2025, 8:59:09 PM
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length, k = m * n, 
        idx = 0, min = Integer.MAX_VALUE;
        int[] pre = new int[k], suf = new int[k], nums = new int[k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % x != grid[0][0] % x) {
                    return -1;
                }
                nums[idx++] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        for (int i = 1; i < k; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        for (int i = k - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < k; i++) {
            int left = (nums[i] * i - pre[i]) / x;
            int right = (suf[i] - nums[i] * (k - i - 1)) / x;
            min = Math.min(min, left + right);
        }
        return min;
    }
}