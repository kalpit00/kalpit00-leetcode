// Last updated: 12/30/2025, 8:01:39 AM
1class Solution {
2    public int maxFrequency(int[] nums, int k) {
3        int n = nums.length, count = 0, max = 0;
4        for (int num : nums) {
5            count += num == k ? 1 : 0;
6        }
7        for (int x = 1; x <= 50; x++) {
8            if (x == k) continue;
9            max = Math.max(max, kadane(nums, x, k));
10        }
11        return count + max;
12    }
13    public int kadane(int[] nums, int x, int k) {
14        int sum = 0, max = Integer.MIN_VALUE;
15        for (int num : nums) {
16            sum += num == x ? 1 : num == k ? -1 : 0;
17            max = Math.max(max, sum);
18            sum = sum < 0 ? 0 : sum;
19        }
20        return max;
21    }
22}