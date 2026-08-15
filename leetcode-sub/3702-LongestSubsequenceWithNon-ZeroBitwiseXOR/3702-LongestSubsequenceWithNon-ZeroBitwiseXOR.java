// Last updated: 8/15/2026, 4:29:55 AM
1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int n = nums.length, xOr = 0;
4        boolean flag = false;
5        for (int num : nums) {
6            flag = num != 0 ? true : flag;
7            xOr ^= num;
8        }
9        return !flag ? 0 : xOr == 0 ? n - 1 : n;
10    }
11}