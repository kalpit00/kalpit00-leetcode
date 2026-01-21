// Last updated: 1/20/2026, 7:20:03 PM
1class Solution {
2
3    public int[] minBitwiseArray(List<Integer> nums) {
4        int n = nums.size();
5        int[] result = new int[n];
6        for (int i = 0; i < n; i++) {
7            int x = nums.get(i);
8            int res = -1;
9            int d = 1;
10            while ((x & d) != 0) {
11                res = x - d;
12                d <<= 1;
13            }
14            result[i] = res;
15        }
16        return result;
17    }
18}