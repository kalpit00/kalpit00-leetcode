// Last updated: 5/25/2026, 5:32:32 AM
1class Solution {
2    public int minOperations(int[] nums, int x) {
3        int n = nums.length, left = 0, right = 0, sum = 0, max = -1, total = 0;
4        for (int num : nums) {
5            total += num;
6        }
7        while (right < n) {
8            sum += nums[right++];
9            while (left < n && sum > total - x) {
10                sum -= nums[left++];
11            }
12            max = sum == total - x ? Math.max(max, right - left) : max;
13        }
14        return max == -1 ? -1 : n - max;
15    }
16}