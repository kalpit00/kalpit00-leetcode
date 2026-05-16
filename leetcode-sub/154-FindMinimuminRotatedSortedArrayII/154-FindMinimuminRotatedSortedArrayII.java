// Last updated: 5/15/2026, 8:03:35 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int pivot = pivotWithDuplicates(nums);
4        return (pivot == -1) ? nums[0] : nums[pivot + 1];
5    }
6    public int pivotWithDuplicates(int[] nums) {
7        int n = nums.length, start = 0, end = n - 1;
8        while (start < n - 1 && nums[start + 1] == nums[start]) {
9            start++;
10        }
11        while (end > 0 && nums[end - 1] == nums[end]) {
12            end--;
13        }
14        while (start <= end) {
15            int mid = start + (end - start) / 2;
16            if (mid < n - 1 && nums[mid] > nums[mid + 1]) {
17                return mid;
18            }
19            if (mid > 0 && nums[mid] < nums[mid - 1]) {
20                return mid - 1;
21            }
22            else if (nums[start] < nums[mid]) {
23                start = mid + 1;
24            }
25            else {
26                end = mid - 1;
27            }
28        }
29        return -1; // Pivot wasn't found, array is not rotated
30    }
31}