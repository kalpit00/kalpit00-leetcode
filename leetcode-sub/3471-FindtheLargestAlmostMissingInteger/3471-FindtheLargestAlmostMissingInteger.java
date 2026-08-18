// Last updated: 8/17/2026, 10:59:34 PM
1class Solution {
2    public int largestInteger(int[] nums, int k) {
3        int n = nums.length, max = -1, uniqueMax = -1, res = -1; 
4        int[] map = new int[51];
5        for (int num : nums) {
6            max = Math.max(max, num);
7            map[num]++;
8        }
9        for (int num : nums) {
10            uniqueMax = map[num] == 1 ? Math.max(uniqueMax, num) : uniqueMax;
11        }
12        if (k == 1) return uniqueMax;
13        if (k == n) return max;
14        if (map[nums[0]] == 1) {
15            res = Math.max(res, nums[0]);
16        }
17        if (map[nums[n - 1]] == 1) {
18            res = Math.max(res, nums[n - 1]);
19        }
20        return res;
21    }
22}