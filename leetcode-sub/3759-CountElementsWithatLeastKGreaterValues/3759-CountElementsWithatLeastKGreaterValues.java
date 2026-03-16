// Last updated: 3/16/2026, 4:11:49 AM
1class Solution {
2    public int countElements(int[] nums, int k) {
3        int n = nums.length, count = 0;
4        if (k == 0) return n;
5        quickSelect(nums, 0, n - 1, n - k);
6        for (int num : nums) {
7            count += num < nums[n - k] ? 1 : 0;
8        }
9        return count;
10    }
11    private int quickSelect(int[] nums, int start, int end, int k) {
12        if (start >= end) {
13            return nums[start];
14        } // take random pivot choice between index [start .. end]
15        int pivotIndex = start + new Random().nextInt(end - start + 1);
16        int pivot[] = partition(nums, start, end, pivotIndex);
17        if (pivot[0] > k) {
18            return quickSelect(nums, start, pivot[0] - 1, k);
19        }
20        else if (pivot[1] < k) {
21            return quickSelect(nums, pivot[1] + 1, end, k);
22        }
23        else {
24            return nums[k];
25        }
26    }
27    // Dutch National Flag Algorithm
28    private int[] partition(int[] nums, int start, int end, int pivotIndex) {
29        int pivot = nums[pivotIndex]; 
30        int i = start, idx = start, j = end;
31        while (idx <= j && i < j) {
32            if (nums[idx] < pivot) {
33                swap(nums, i++, idx++);
34            }
35            else if (nums[idx] > pivot) {
36                swap(nums, j--, idx);
37            }
38            else {
39                idx++;
40            }
41        }
42        return new int[]{i, j};
43    }
44    private void swap(int[] nums, int i, int j) {
45        int temp = nums[i];
46        nums[i] = nums[j];
47        nums[j] = temp;
48    }
49}