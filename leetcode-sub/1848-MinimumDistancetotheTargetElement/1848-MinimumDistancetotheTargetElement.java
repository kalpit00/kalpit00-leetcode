// Last updated: 4/12/2026, 9:39:59 PM
1class Solution {
2    public int getMinDistance(int[] nums, int target, int start) {
3        int n = nums.length, min = n;
4        for (int i = 0; i < n; i++) {
5            if (nums[i] == target) {
6                min = Math.min(min, Math.abs(i - start));
7            }
8        }
9        return min;
10    }
11}