// Last updated: 8/2/2026, 7:14:14 AM
1class Solution {
2    public int minOperations(int[] nums, int k) {
3        int count = 0;
4        for (int num : nums) {
5            count += num < k ? 1 : 0;
6        }
7        return count;
8    }
9}