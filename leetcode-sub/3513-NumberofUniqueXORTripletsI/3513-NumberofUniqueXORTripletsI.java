// Last updated: 7/22/2026, 11:08:48 PM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length, count = 0, x = n;
4        while (x != 0) { // keep halving the length of nums[]
5            x /= 2; // x >>= 1;
6            count++;
7        }
8        return n <= 2 ? n : 1 << count; // ans = 2^count
9    }
10}