// Last updated: 3/19/2026, 11:02:27 PM
1class Solution {
2    public int[][] minAbsDiff(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        int[][] res = new int[m - k + 1][n - k + 1];
5        for (int i = 0; i <= m - k; i++) {
6            for (int j = 0; j <= n - k; j++) {
7                Set<Integer> set = new HashSet<>();
8                for (int r = 0; r < k; r++) {
9                    for (int c = 0; c < k; c++) {
10                        set.add(grid[i + r][j + c]);
11                    }
12                }
13                res[i][j] = helper(set);
14            }
15        }
16        return res;
17    }
18    private int helper(Set<Integer> set) {
19        List<Integer> nums = new ArrayList<>(set);
20        Collections.sort(nums);
21        int n = nums.size(), min = Integer.MAX_VALUE;
22        for (int i = 1; i < n; i++) {
23            min = Math.min(min, Math.abs(nums.get(i) - nums.get(i - 1)));
24        }
25        return min == Integer.MAX_VALUE ? 0 : min;
26    }
27}