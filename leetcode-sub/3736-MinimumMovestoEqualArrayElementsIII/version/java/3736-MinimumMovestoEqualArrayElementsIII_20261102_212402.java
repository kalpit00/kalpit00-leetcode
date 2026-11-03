// Last updated: 11/2/2026, 9:24:02 PM
1class Solution {
2    public int minMoves(int[] nums) {
3        int n = nums.length, max = 0, sum = 0;
4        for (int num : nums) {
5            sum += num;
6            max = Math.max(max, num);
7        }
8        return max * n - sum;
9    }
10}