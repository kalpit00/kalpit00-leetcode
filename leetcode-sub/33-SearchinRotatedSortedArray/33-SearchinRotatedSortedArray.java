// Last updated: 5/21/2026, 10:27:39 PM
1class Solution {
2    public int search(int[] nums, int target) {
3        int pivot = pivot(nums);
4        if (pivot == -1) {
5            return binarySearch(nums, target, 0, nums.length - 1);
6        }
7        if (nums[pivot] == target) {
8            return pivot;
9        }
10        int ans = binarySearch(nums, target, 0, pivot);
11        if (ans != -1) {
12            return ans;
13        }        
14        return binarySearch(nums, target, pivot + 1, nums.length - 1);
15    }
16
17    public int binarySearch(int[] nums, int target, int from, int to) {
18        int start = from, end = to;
19        while (start <= end) {
20            int mid = start + (end - start)/2;
21            if (nums[mid] == target) {
22                return mid;
23            }
24            if (nums[mid] > target) {
25                end = mid - 1;
26            }
27            else {
28                start = mid + 1;
29            }
30        }
31        return -1;
32    }
33
34    public int pivot(int[] nums) {
35        int n = nums.length;
36        int start = 0, end = n - 1;
37        while (start <= end) {
38            int mid = start + (end - start)/2;
39            if (mid < n - 1 && nums[mid] > nums[mid + 1]) {
40                return mid;
41            }
42            if (mid > 0 && nums[mid] < nums[mid - 1]) {
43                return mid - 1;
44            }
45            else if (nums[start] < nums[mid]) {
46                start = mid + 1;
47            }
48            else {
49                end = mid - 1;
50            }
51        }
52        return -1; // pivot wasnt found, original sorted array!
53    }
54}