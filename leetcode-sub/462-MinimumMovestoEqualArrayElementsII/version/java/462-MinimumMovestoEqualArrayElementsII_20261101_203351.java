// Last updated: 11/1/2026, 8:33:51 PM
1class Solution {
2    public int minMoves2(int[] nums) {
3        int n = nums.length, sum = 0;
4        int median = quickSelect(nums, 0, n - 1, (n - 1) / 2);        
5        for (int num : nums) {
6            sum += Math.abs(median - num);
7        }
8        return sum;
9    }
10    private int quickSelect(int[] nums, int start, int end, int k) {
11        if (start >= end) {
12            return nums[start];
13        } // take random pivot choice between index [start .. end]
14        int pivotIndex = start + new Random().nextInt(end - start + 1);
15        int pivot[] = partition(nums, start, end, pivotIndex);
16        if (pivot[0] > k) {
17            return quickSelect(nums, start, pivot[0] - 1, k);
18        }
19        else if (pivot[1] < k) {
20            return quickSelect(nums, pivot[1] + 1, end, k);
21        }
22        else {
23            return nums[k];
24        }
25    }
26    // Dutch National Flag Algorithm
27    private int[] partition(int[] nums, int start, int end, int pivotIndex) {
28        int pivot = nums[pivotIndex]; 
29        int i = start, idx = start, j = end;
30        while (idx <= j && i < j) {
31            if (nums[idx] < pivot) {
32                swap(nums, i++, idx++);
33            }
34            else if (nums[idx] > pivot) {
35                swap(nums, j--, idx);
36            }
37            else {
38                idx++;
39            }
40        }
41        return new int[]{i, j};
42    }
43    private void swap(int[] nums, int i, int j) {
44        int temp = nums[i];
45        nums[i] = nums[j];
46        nums[j] = temp;
47    }
48}