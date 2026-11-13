// Last updated: 11/13/2026, 12:17:27 PM
1class Solution {
2    public int[] decode(int[] encoded, int first) {
3        int n = encoded.length + 1;
4        int[] nums = new int[n];
5        nums[0] = first;
6        for (int i = 1; i < n; i++) {
7            nums[i] = nums[i - 1] ^ encoded[i - 1];
8        }
9        return nums;
10    }
11}