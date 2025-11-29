// Last updated: 11/29/2025, 5:11:32 AM
1class Solution {
2    public int minOperations(int[] nums, int k) {
3        int sum = 0;
4        for (int num : nums) {
5            sum += num;
6        }
7        return sum % k;
8    }
9}