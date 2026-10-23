// Last updated: 10/22/2026, 9:19:10 PM
1class Solution {
2    public int sortPermutation(int[] nums) {
3        int n = nums.length, k = -1;
4        for (int i = 0; i < n; i++) {
5            if (nums[i] != i) {
6                k &= nums[i];
7            }
8        }
9        return k == -1 ? 0 : k;
10    }
11}