// Last updated: 3/23/2026, 10:48:19 PM
1class Solution {
2    public int[][] constructProductMatrix(int[][] grid) {
3        int m = grid.length, n = grid[0].length, k = 0;
4        int[] nums = new int[m * n];
5        for (int[] cell : grid) {
6            for (int num : cell) {
7                nums[k++] = num;
8            }
9        }
10        k = 0;
11        nums = productExceptSelf(nums);
12        int[][] res = new int[m][n];
13        for (int i = 0; i < m; i++) {
14            for (int j = 0; j < n; j++) {
15                res[i][j] = nums[k++];
16            }
17        }
18        return res;
19    }
20    public int[] productExceptSelf(int[] nums) {
21        int n = nums.length, mod = 12345;
22        int[] pre = new int[n];
23        int[] suf = new int[n];
24        pre[0] = 1;
25        suf[n - 1] = 1;
26        for (int i = 1; i < n; i++) {
27            pre[i] = (pre[i-1] % mod) * (nums[i-1] % mod) % mod;
28        }
29        for (int i = n - 2; i >= 0; i--) {
30            suf[i] = (suf[i+1] % mod) * (nums[i+1] % mod) % mod;
31        }
32        for (int i = 0; i < n; i++) {
33            nums[i] = (pre[i] * suf[i]) % mod;
34        }
35        return nums;
36    }
37}