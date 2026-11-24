// Last updated: 11/23/2026, 10:06:59 PM
1class Solution {
2    public int maxLength(int[] nums) {
3        int left = 0, right = 0, max = 2, n = nums.length, prod = 1;
4        while (right < n) {
5            while (gcd(prod, nums[right]) > 1) {
6                prod /= nums[left++];
7            }
8            prod *= nums[right++];
9            max = Math.max(max, right - left);
10        }
11        return max;
12    }
13    public int gcd(int x, int y) {
14        return y == 0 ? x : gcd(y, x % y);
15    }
16}