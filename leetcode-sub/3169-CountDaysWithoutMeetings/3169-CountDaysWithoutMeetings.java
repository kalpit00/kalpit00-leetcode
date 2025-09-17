// Last updated: 9/17/2025, 4:41:34 AM
class Solution {
    public int maxHeight(int[][] grid) {
        int n = grid.length, max = 0;
        int[] dp = new int[n];
        for (int[] item : grid) {
            Arrays.sort(item); // first sort each <l, w, h> -> interchangable
        } // then sort grid based on desc order on 1st dim -> 2nd -> 3rd
        Arrays.sort(grid, (a, b) -> a[0] != b[0] ? b[0] - a[0] : 
        a[1] != b[1] ? b[1] - a[1] : b[2] - a[2]);
        for (int i = 0; i < n; i++) {
            dp[i] = grid[i][2];
            for (int j = 0; j < i; j++) {
                if (grid[i][0] <= grid[j][0] && grid[i][1] <= grid[j][1] &&
                grid[i][2] <= grid[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + grid[i][2]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}