// Last updated: 11/15/2026, 2:55:19 AM
1class Solution {
2    public int minOperations(int[] nums) {
3        for (int num : nums) {
4            if (num != nums[0]) return 1;
5        }
6        return 0;
7    }
8}