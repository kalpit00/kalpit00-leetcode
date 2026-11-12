// Last updated: 11/11/2026, 8:26:50 PM
1class Solution {
2    public int longestMonotonicSubarray(int[] nums) {
3        int n = nums.length, max = 1;
4        for (int i = 0; i < n; i++) {
5            int m = 1; // m = streak length
6            while (i < n - 1 && nums[i] < nums[i + 1]) {
7                i++;
8                m++;
9            }
10            max = Math.max(max, m);
11        }
12        for (int i = 0; i < n; i++) {
13            int m = 1; // m = streak length
14            while (i < n - 1 && nums[i] > nums[i + 1]) {
15                i++;
16                m++;
17            }
18            max = Math.max(max, m);
19        }
20        return max;
21    }
22}