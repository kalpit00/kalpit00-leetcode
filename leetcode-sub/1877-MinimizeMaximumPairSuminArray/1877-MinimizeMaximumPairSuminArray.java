// Last updated: 1/23/2026, 7:27:09 PM
1class Solution {
2    public int minPairSum(int[] nums) {
3        int n = nums.length, sum = 0;
4        Arrays.sort(nums);
5        for (int i = 0; i < n / 2; i++) {
6            sum = Math.max(sum, nums[i] + nums[n - i - 1]);
7        }
8        return sum;
9    }
10}