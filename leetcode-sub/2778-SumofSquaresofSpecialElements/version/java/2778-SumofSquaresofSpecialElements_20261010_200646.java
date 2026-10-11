// Last updated: 10/10/2026, 8:06:46 PM
1class Solution {
2    public int sumOfSquares(int[] nums) {
3        int n = nums.length;
4        int sum = 0;
5        for (int i = 1; i <= n; i++) {
6            if (n % i == 0) {
7                sum+= nums[i-1]*nums[i-1];
8            }
9        }
10        return sum;
11    }
12}