// Last updated: 7/20/2026, 12:44:43 AM
1class Solution {
2    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length, idx = 0;
4        int[] nums = new int[m * n];
5        for (int i = 0; i < m; i++) {
6            for (int j = 0; j < n; j++) {
7                nums[idx++] = grid[i][j];
8            }
9        }
10        rotate(nums, k);
11        idx = 0;
12        List<List<Integer>> res = new ArrayList<>();
13        for (int i = 0; i < m; i++) {
14            res.add(new ArrayList<>());
15            for (int j = 0; j < n; j++) {
16                res.get(i).add(nums[idx++]);
17            }
18        }
19        return res;
20    }
21    public void rotate(int[] nums, int k) {
22        int n = nums.length;
23        k = k % n;
24        reverse(nums, 0 , n - 1);
25        reverse(nums, 0, k - 1);
26        reverse(nums, k, n - 1);
27    }
28    public void reverse(int[] nums, int start, int end) {
29        while (start < end) {
30            int temp = nums[start];
31            nums[start] = nums[end];
32            nums[end] = temp;
33            start++;
34            end--;
35        }
36    }
37}