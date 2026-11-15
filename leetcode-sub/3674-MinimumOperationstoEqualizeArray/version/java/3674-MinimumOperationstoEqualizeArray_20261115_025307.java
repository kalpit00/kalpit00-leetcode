// Last updated: 11/15/2026, 2:53:07 AM
1class Solution {
2    public int minOperations(int[] nums) {
3        int count = 0, n = nums.length;
4        for (int num : nums) {
5            count += num == nums[0] ? 1 : 0;
6        }
7        return count < n ? 1 : 0;
8    }
9}