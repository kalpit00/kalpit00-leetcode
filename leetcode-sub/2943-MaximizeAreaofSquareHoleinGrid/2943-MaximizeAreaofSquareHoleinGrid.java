// Last updated: 1/14/2026, 8:23:24 PM
1class Solution {
2    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
3        Arrays.sort(hBars);
4        Arrays.sort(vBars);
5        int hmax = helper(hBars), vmax = helper(vBars);
6        int side = Math.min(hmax, vmax) + 1;
7        return side * side;
8    } // helper ftn to count largest streak of consecutive integers in sorted[]
9    private int helper(int[] nums) {
10        int n = nums.length, max = 1;
11        for (int i = 0; i < n; i++) {
12            int m = 1;
13            while (i < n - 1 && nums[i] == nums[i + 1] - 1) {
14                i++;
15                m++;
16            }
17            max = Math.max(max, m);            
18        }
19        return max;
20    }
21}