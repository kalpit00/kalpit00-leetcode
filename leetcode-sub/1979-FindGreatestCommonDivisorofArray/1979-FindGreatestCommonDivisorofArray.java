// Last updated: 7/17/2026, 9:51:26 PM
1class Solution {
2    public int findGCD(int[] nums) {
3        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
4        for (int num : nums) {
5            min = Math.min(min, num);
6            max = Math.max(max, num);
7        }
8        return gcd(max, min);
9    }
10    public int gcd(int x, int y) {
11        return y == 0 ? x : gcd(y, x % y);
12    }
13}