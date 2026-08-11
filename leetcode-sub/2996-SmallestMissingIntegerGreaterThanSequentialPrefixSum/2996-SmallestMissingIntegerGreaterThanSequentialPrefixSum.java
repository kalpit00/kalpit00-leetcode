// Last updated: 8/11/2026, 2:43:24 AM
1class Solution {
2    public int missingInteger(int[] nums) {
3        int n = nums.length, sum = nums[0], i = 1;
4        while (i < n && nums[i] == nums[i - 1] + 1) {
5            sum += nums[i++];
6        }
7        Arrays.sort(nums, i, n);
8        for (i = i - 1; i < n; i++) {
9            if (nums[i] == sum) {
10                sum++;
11            }
12        }
13        return sum;
14    }
15}