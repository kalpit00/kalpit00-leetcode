// Last updated: 6/7/2026, 8:30:01 PM
1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3        int n = nums.length, left = 0, right = n - 1;
4        int[] res = new int[n];
5        for (int i = 0, j = n - 1; i < n; i++, j--) {
6            if (nums[i] < pivot) {
7                res[left++] = nums[i];
8            }
9            if (nums[j] > pivot) {
10                res[right--] = nums[j];
11            }
12        }
13        while (left <= right) {
14            res[left++] = pivot;
15        }
16        return res;
17    }
18}