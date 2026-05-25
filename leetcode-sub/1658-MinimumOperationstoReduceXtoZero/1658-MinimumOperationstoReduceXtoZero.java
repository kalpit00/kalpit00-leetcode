// Last updated: 5/25/2026, 5:36:27 AM
1class Solution {
2    public int minOperations(int[] nums, int x) {
3        int n = nums.length, left = 0, right = 0, sum = 0, max = -1,
4        windowSum = 0;
5        for (int num : nums) {
6            sum += num;
7        }
8        while (right < n) {
9            windowSum += nums[right++];
10            while (left < n && windowSum > sum - x) {
11                windowSum -= nums[left++];
12            }
13            max = windowSum == sum - x ? Math.max(max, right - left) : max;
14        }
15        return max == -1 ? -1 : n - max;
16    }
17}