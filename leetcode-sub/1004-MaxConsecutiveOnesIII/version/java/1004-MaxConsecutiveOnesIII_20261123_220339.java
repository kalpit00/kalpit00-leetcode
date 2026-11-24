// Last updated: 11/23/2026, 10:03:39 PM
1class Solution {
2    public int longestOnes(int[] nums, int k) {
3        int left = 0, right = 0, max = 0, count = 0, n = nums.length;
4        while (right < n) {
5            count += nums[right++] == 0 ? 1 : 0;
6            while (count > k) {
7                count -= nums[left++] == 0 ? 1 : 0;
8            }
9            max = Math.max(max, right - left);
10        }
11        return max;
12    }
13}