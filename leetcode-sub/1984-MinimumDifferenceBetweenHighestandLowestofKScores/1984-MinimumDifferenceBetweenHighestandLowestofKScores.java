// Last updated: 1/24/2026, 7:35:12 PM
1class Solution {
2    public int minimumDifference(int[] nums, int k) {
3        int n = nums.length, min = Integer.MAX_VALUE;
4        Arrays.sort(nums);
5        for (int i = 0; i <= n - k; i++) {
6            min = Math.min(min, nums[i + k - 1] - nums[i]);
7        }
8        return min;
9    }
10}