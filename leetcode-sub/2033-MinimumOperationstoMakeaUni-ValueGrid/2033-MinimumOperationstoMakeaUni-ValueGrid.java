// Last updated: 4/28/2026, 3:44:38 AM
1class Solution {
2    public int minOperations(int[][] grid, int x) {
3        int m = grid.length, n = grid[0].length, k = m * n, idx = 0, sum = 0;
4        int[] nums = new int[k];
5        for (int i = 0; i < m; i++) {
6            for (int j = 0; j < n; j++) {
7                nums[idx++] = grid[i][j];
8            }
9        }
10        int median = quickSelect(nums, 0, k - 1, (k - 1) / 2);        
11        for (int num : nums) {
12            if (num % x != median % x) {
13                return -1;
14            }
15            sum += Math.abs(median - num) / x;
16        }
17        return sum;   
18    }
19    private int quickSelect(int[] nums, int start, int end, int k) {
20        if (start >= end) {
21            return nums[start];
22        } // take random pivot choice between index [start .. end]
23        int pivotIndex = start + new Random().nextInt(end - start + 1);
24        int pivot[] = partition(nums, start, end, pivotIndex);
25        if (pivot[0] > k) {
26            return quickSelect(nums, start, pivot[0] - 1, k);
27        }
28        else if (pivot[1] < k) {
29            return quickSelect(nums, pivot[1] + 1, end, k);
30        }
31        else {
32            return nums[k];
33        }
34    }
35    // Dutch National Flag Algorithm
36    private int[] partition(int[] nums, int start, int end, int pivotIndex) {
37        int pivot = nums[pivotIndex]; 
38        int i = start, idx = start, j = end;
39        while (idx <= j && i < j) {
40            if (nums[idx] < pivot) {
41                swap(nums, i++, idx++);
42            }
43            else if (nums[idx] > pivot) {
44                swap(nums, j--, idx);
45            }
46            else {
47                idx++;
48            }
49        }
50        return new int[]{i, j};
51    }
52    private void swap(int[] nums, int i, int j) {
53        int temp = nums[i];
54        nums[i] = nums[j];
55        nums[j] = temp;
56    }
57}