// Last updated: 12/1/2025, 4:52:18 AM
1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
4        for (int num : nums) {
5            max = Math.max(max, num);
6            min = Math.min(min, num);
7        }
8        return (long) k * (max - min);
9    }
10}