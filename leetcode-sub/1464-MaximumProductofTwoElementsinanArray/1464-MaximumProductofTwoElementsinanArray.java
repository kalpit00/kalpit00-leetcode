// Last updated: 7/26/2026, 9:14:14 PM
1class Solution {
2    public int maxProduct(int[] nums) {
3        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
4        for (int num : nums) {
5            if (num > max) {
6                secondMax = max;
7                max = num;
8            } else if (num > secondMax) {
9                secondMax = num;
10            }
11        }
12        return (max - 1) * (secondMax - 1);
13    }
14}