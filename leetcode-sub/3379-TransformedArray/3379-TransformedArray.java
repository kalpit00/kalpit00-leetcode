// Last updated: 2/4/2026, 8:06:11 PM
1class Solution {
2    public int[] constructTransformedArray(int[] nums) {
3        int n = nums.length;
4        int res[] = new int[n];
5        for (int i = 0; i < n; ++i) {
6            res[i] = nums[(i + nums[i] % n + n) % n];
7        }
8        return res;
9    }
10}