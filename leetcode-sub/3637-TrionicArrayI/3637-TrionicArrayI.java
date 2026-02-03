// Last updated: 2/2/2026, 8:19:52 PM
1class Solution {
2    public boolean isTrionic(int[] nums) {
3        if (nums[0] >= nums[1]) {
4            return false;
5        }
6        int n = nums.length, count = 1;
7        for (int i = 2; i < n; i++) {
8            if (nums[i - 1] == nums[i]) {
9                return false;
10            }
11            if ((nums[i - 2] - nums[i - 1]) * (nums[i - 1] - nums[i]) < 0) {
12                count++;
13            }
14        }
15        return count == 3;
16    }
17}