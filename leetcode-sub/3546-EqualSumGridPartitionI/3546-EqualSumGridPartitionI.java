// Last updated: 3/24/2026, 10:57:45 PM
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        long[] preRow = new long[m], preCol = new long[n];
5        for (int i = 0; i < m; i++) {
6            for (int j = 0; j < n; j++) {
7                preRow[i] += grid[i][j];
8                preCol[j] += grid[i][j];
9            }
10        }
11        return pivotIndex(preRow) || pivotIndex(preCol);
12    }
13    public boolean pivotIndex(long[] nums) {
14        int n = nums.length;
15        long[] pre = new long[n], suf = new long[n];
16        for (int i = 1; i < n; i++) {
17            pre[i] = pre[i - 1] + nums[i - 1];
18        }
19        for (int i = n - 2; i >= 0; i--) {
20            suf[i] = suf[i + 1] + nums[i + 1];
21        }
22        for (int i = 0; i < n; i++) {
23            if (pre[i] + nums[i] == suf[i]) {
24                return true;
25            }
26        }
27        return false;
28    }
29}