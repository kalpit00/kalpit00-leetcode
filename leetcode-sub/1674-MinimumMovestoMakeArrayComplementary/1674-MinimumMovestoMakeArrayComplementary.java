// Last updated: 5/12/2026, 8:02:48 PM
1class Solution {
2    public int minMoves(int[] nums, int limit) {
3        int n = nums.length, min = Integer.MAX_VALUE, size = 200001;
4        int[] count = new int[size], sum = new int[size];
5        for (int i = 0; i < n/ 2; i++) {
6            int start = 1 + Math.min(nums[i], nums[n - i - 1]);
7            int end = limit + Math.max(nums[i], nums[n - i - 1]);
8            count[start]++;
9            count[end + 1]--;
10            sum[nums[i] + nums[n - i - 1]]++;
11        }
12        for (int i = 1; i < size; i++) {
13            count[i] += count[i - 1];
14        }
15        for (int i = 2; i < size; i++) {
16            min = Math.min(min, n - count[i] - sum[i]);
17        }
18        return min;
19    }
20}