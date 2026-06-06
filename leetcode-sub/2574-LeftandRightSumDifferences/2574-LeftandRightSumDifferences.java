// Last updated: 6/5/2026, 8:08:10 PM
1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3        int n = nums.length, sum = 0, total = 0;
4        int[] res = new int[n];
5        for (int num : nums) {
6            total += num;
7        }
8        for (int i = 0; i < n; i++) {
9            res[i] = Math.abs(total - nums[i] - 2 * sum);
10            sum += nums[i];
11        }
12        return res;
13    }
14}