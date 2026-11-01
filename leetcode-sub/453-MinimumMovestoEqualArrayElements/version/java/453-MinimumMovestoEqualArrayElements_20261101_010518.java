// Last updated: 11/1/2026, 1:05:18 AM
1class Solution {
2    public int minMoves(int[] nums) {
3        int min = Integer.MAX_VALUE, n = nums.length, sum = 0;
4        for (int num : nums) {
5            sum += num;
6            min = Math.min(min, num);
7        }
8        return sum - min * n;
9    }
10}