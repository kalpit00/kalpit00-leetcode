// Last updated: 11/13/2026, 10:09:09 PM
1class Solution {
2    int min = Integer.MAX_VALUE;
3    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
4        for (int k = l; k <= r; k++) {
5            helper(nums, k);
6        }
7        return min == Integer.MAX_VALUE ? -1 : min;
8    }
9    private void helper(List<Integer> nums, int k) {
10        int sum = 0, n = nums.size();
11        for (int i = 0; i < k; i++) {
12            sum += nums.get(i);
13        }
14        min = sum > 0 ? Math.min(min, sum) : min;
15        for (int i = k; i < n; i++) {
16            sum += nums.get(i) - nums.get(i - k);
17            min = sum > 0 ? Math.min(min, sum) : min;
18        }
19    }
20}