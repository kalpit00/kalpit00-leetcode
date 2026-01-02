// Last updated: 1/2/2026, 3:07:10 PM
1class Solution {
2    public int repeatedNTimes(int[] nums) {
3        int n = nums.length;
4        for (int i = 0; i < n - 2; i++) {
5            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
6                return nums[i];
7            }
8        }
9        return nums[n - 1];
10    }
11}