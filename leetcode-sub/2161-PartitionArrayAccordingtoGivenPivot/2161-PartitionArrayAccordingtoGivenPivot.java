// Last updated: 6/7/2026, 8:30:17 PM
1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3        int n = nums.length, idx = 0, count = 0;
4        int[] res = new int[n];
5        for (int i = 0; i < n; i++) {
6            if (nums[i] < pivot) {
7                res[idx++] = nums[i];
8            }
9            count += nums[i] == pivot ? 1 : 0;
10        }
11        for (int i = 0; i < count; i++) {
12            res[idx++] = pivot;
13        }
14        for (int i = 0; i < n; i++) {
15            if (nums[i] > pivot) {
16                res[idx++] = nums[i];
17            }
18        }
19        return res;
20    }
21}