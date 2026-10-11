// Last updated: 10/10/2026, 8:07:08 PM
1class Solution {
2    public int sumOfSquares(int[] nums) {
3        int n = nums.length, sum = 0;
4        for (int i = 1; i <= n; i++) {
5            sum += n % i == 0 ? nums[i - 1] * nums[i - 1] : 0;
6        }
7        return sum;
8    }
9}