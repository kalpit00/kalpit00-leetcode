// Last updated: 6/26/2026, 11:58:08 AM
1class Solution {
2    public long minOperations(int[] nums) {
3        long sum = 0;
4        int n = nums.length;
5        for (int i = 0; i < n - 1; i++) {
6            sum += nums[i] > nums[i + 1] ? nums[i] - nums[i + 1] : 0;
7        }
8        return sum;
9    }
10}