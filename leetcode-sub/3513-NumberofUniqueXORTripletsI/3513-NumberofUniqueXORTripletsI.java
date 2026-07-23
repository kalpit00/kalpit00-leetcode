// Last updated: 7/22/2026, 10:59:50 PM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length, count = 1;
4        while (count <= n) {
5            count <<= 1;
6        }
7        return n <= 2 ? n : count;
8    }
9}