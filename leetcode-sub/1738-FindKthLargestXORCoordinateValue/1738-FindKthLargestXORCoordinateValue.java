// Last updated: 3/16/2026, 5:16:11 AM
1class Solution {
2    public int kthLargestValue(int[][] matrix, int k) {
3        int m = matrix.length, n = matrix[0].length, idx = 0;
4        int[] nums = new int[m * n];
5        int[][] pre = new int[m][n];
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                int x = (i - 1 < 0 ? 0 : pre[i - 1][j]);
9                int y = (j - 1 < 0 ? 0 : pre[i][j - 1]);
10                int z = (i - 1 < 0 || j - 1 < 0 ? 0 : pre[i - 1][j - 1]);
11                pre[i][j] = (x ^ y ^ z ^ matrix[i][j]);
12                nums[idx++] = pre[i][j];
13            }
14        }
15        return quickSelect(nums, 0, m * n - 1, k - 1);
16    }
17
18    private int quickSelect(int[] nums, int start, int end, int k) {
19        if (start >= end) {
20            return nums[start];
21        } // take random pivot choice between index [start .. end]
22        int pivotIndex = start + new Random().nextInt(end - start + 1);
23        int pivot[] = partition(nums, start, end, pivotIndex);
24        if (pivot[0] > k) {
25            return quickSelect(nums, start, pivot[0] - 1, k);
26        }
27        else if (pivot[1] < k) {
28            return quickSelect(nums, pivot[1] + 1, end, k);
29        }
30        else {
31            return nums[k];
32        }
33    }
34    // Dutch National Flag Algorithm
35    private int[] partition(int[] nums, int start, int end, int pivotIndex) {
36        int pivot = nums[pivotIndex]; 
37        int i = start, idx = start, j = end;
38        while (idx <= j && i < j) {
39            if (nums[idx] > pivot) {
40                swap(nums, i++, idx++);
41            }
42            else if (nums[idx] < pivot) {
43                swap(nums, j--, idx);
44            }
45            else {
46                idx++;
47            }
48        }
49        return new int[]{i, j};
50    }
51    private void swap(int[] nums, int i, int j) {
52        int temp = nums[i];
53        nums[i] = nums[j];
54        nums[j] = temp;
55    }
56}