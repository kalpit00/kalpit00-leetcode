// Last updated: 5/22/2026, 11:16:45 PM
1class Solution {
2    public boolean check(int[] nums) {
3        int n = nums.length, count = 0;
4        for (int i = 0; i < n - 1; i++) {
5            count += nums[i] > nums[i + 1] ? 1 : 0;
6        }
7        count += nums[n - 1] > nums[0] ? 1 : 0;
8        return count <= 1;
9    }
10}