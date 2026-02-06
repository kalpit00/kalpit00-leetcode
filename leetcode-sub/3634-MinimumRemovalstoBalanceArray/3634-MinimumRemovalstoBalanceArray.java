// Last updated: 2/5/2026, 9:04:19 PM
1class Solution {
2    public int minRemoval(int[] nums, int k) {
3        int n = nums.length, min = n, right = 0;
4        Arrays.sort(nums);
5        for (int left = 0; left < n; left++) {
6            while (right < n && nums[right] <= (long) nums[left] * k) {
7                right++;
8            }
9            min = Math.min(min, n - (right - left));
10        }
11        return min;
12    }
13}