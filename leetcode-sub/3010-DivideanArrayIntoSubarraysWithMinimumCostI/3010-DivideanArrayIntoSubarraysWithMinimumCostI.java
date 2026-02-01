// Last updated: 1/31/2026, 9:43:24 PM
1class Solution {
2    public int minimumCost(int[] nums) {
3        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
4        for (int i = 1; i < nums.length; i++) {
5            if (nums[i] < min) {
6                secondMin = min;
7                min = nums[i];
8            }
9            else if (nums[i] < secondMin) {
10                secondMin = nums[i];
11            }
12        }
13        return nums[0] + min + secondMin;
14    }
15}