// Last updated: 2/14/2026, 9:20:07 PM
1class Solution {
2    public int[] rearrangeArray(int[] nums) {
3        wiggleSort(nums);
4        return nums;
5    }
6    public void wiggleSort(int[] nums) {
7        int n = nums.length;
8        int median = quickSelect(nums, 0, n - 1, (n - 1) / 2);
9        int idx = 0, i = 1, j = n % 2 == 0 ? n - 2 : n - 1;
10        while (idx < n) {
11            if (nums[idx] > median && (idx > i || (idx <= i && idx % 2 == 0))) {
12                swap(nums, idx, i);
13                i += 2;
14            }
15    else if (nums[idx] < median && (idx < j || (idx >= j && idx % 2 == 1))) {
16                swap(nums, idx, j);
17                j -= 2;
18            }
19            else {
20                idx++;
21            }
22        }
23    }
24
25    private int quickSelect(int[] nums, int start, int end, int k) {
26        if (start >= end) {
27            return nums[start];
28        } // take random pivot choice between index [start .. end]
29        int pivotIndex = start + new Random().nextInt(end - start + 1);
30        int pivot[] = partition(nums, start, end, pivotIndex);
31        if (pivot[0] > k) {
32            return quickSelect(nums, start, pivot[0] - 1, k);
33        }
34        else if (pivot[1] < k) {
35            return quickSelect(nums, pivot[1] + 1, end, k);
36        }
37        else {
38            return nums[k];
39        }
40    }
41    // Dutch National Flag Algorithm
42    private int[] partition(int[] nums, int start, int end, int pivotIndex) {
43        int pivot = nums[pivotIndex]; 
44        int i = start, idx = start, j = end;
45        while (idx <= j && i < j) {
46            if (nums[idx] < pivot) {
47                swap(nums, i++, idx++);
48            }
49            else if (nums[idx] > pivot) {
50                swap(nums, j--, idx);
51            }
52            else {
53                idx++;
54            }
55        }
56        return new int[]{i, j};
57    }
58    private void swap(int[] nums, int i, int j) {
59        int temp = nums[i];
60        nums[i] = nums[j];
61        nums[j] = temp;
62    }
63}