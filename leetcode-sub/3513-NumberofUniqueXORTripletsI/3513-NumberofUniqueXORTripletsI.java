// Last updated: 7/22/2026, 11:12:49 PM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length, m = 32 - Integer.numberOfLeadingZeros(n);
4        return n <= 2 ? n : 1 << m; // ans = 2^bitLength of n in binary
5    }
6}