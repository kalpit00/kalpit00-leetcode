// Last updated: 12/5/2025, 12:19:59 AM
1class Solution {
2    public int countPartitions(int[] nums) {
3        int n = nums.length, pre = 0, sum = 0, count = 0;
4        for (int num : nums) {
5            sum += num;
6        }
7        for (int i = 0; i < n - 1; i++) {
8            pre += nums[i];
9            sum -= nums[i];
10            count += (pre - sum) % 2 == 0 ? 1 : 0;
11        }
12        return count;
13    }
14}