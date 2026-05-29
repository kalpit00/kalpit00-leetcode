// Last updated: 5/29/2026, 12:36:25 AM
1class Solution {
2    public int minElement(int[] nums) {
3        int min = Integer.MAX_VALUE;
4        for (int num : nums) {
5            int sum = 0, n = num;
6            while (n > 0) {
7                sum += n % 10;
8                n /= 10;
9            }
10            min = Math.min(min, sum);
11        }
12        return min;
13    }
14}