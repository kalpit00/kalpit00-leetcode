// Last updated: 5/14/2026, 9:26:41 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int pivot = pivot(nums);
4        return (pivot == -1) ? nums[0] : nums[pivot + 1];
5    }
6    public int pivot(int[] nums) {
7        int n = nums.length, start = 0, end = n - 1;
8        while (start <= end) {
9            int mid = start + (end - start)/2;
10            if (mid < n - 1 && nums[mid] > nums[mid + 1]) {
11                return mid;
12            }
13            if (mid > 0 && nums[mid] < nums[mid - 1]) {
14                return mid - 1;
15            }
16            else if (nums[start] < nums[mid]) {
17                start = mid + 1;
18            }
19            else { // or else if works too
20                end = mid - 1;
21            }
22        }
23        return -1; // pivot wasnt found, original sorted array!
24    }
25}