// Last updated: 12/25/2025, 5:50:45 AM
1class Solution {
2    public long maximumHappinessSum(int[] nums, int k) {
3        long sum = 0;
4        int n = nums.length, count = 0;
5        quickSelect(nums, 0, n - 1, k - 1);
6        Arrays.sort(nums, 0, k);        
7        for (int i = k - 1; i >= 0; i--) {
8            sum += Math.max(0, nums[i] - count++);
9        }
10        return sum;
11    }
12    private int quickSelect(int[] nums, int start, int end, int k) {
13        if (start >= end) {
14            return nums[start];
15        } // take random pivot choice between index [start .. end]
16        int pivotIndex = start + new Random().nextInt(end - start + 1);
17        int pivot[] = partition(nums, start, end, pivotIndex);
18        if (pivot[0] > k) {
19            return quickSelect(nums, start, pivot[0] - 1, k);
20        }
21        else if (pivot[1] < k) {
22            return quickSelect(nums, pivot[1] + 1, end, k);
23        }
24        else {
25            return nums[k];
26        }
27    }
28    // Dutch National Flag Algorithm
29    private int[] partition(int[] nums, int start, int end, int pivotIndex) {
30        int pivot = nums[pivotIndex]; 
31        int i = start, idx = start, j = end;
32        while (idx <= j && i < j) {
33            if (nums[idx] > pivot) {
34                swap(nums, i++, idx++);
35            }
36            else if (nums[idx] < pivot) {
37                swap(nums, j--, idx);
38            }
39            else {
40                idx++;
41            }
42        }
43        return new int[]{i, j};
44    }
45    private void swap(int[] nums, int i, int j) {
46        int temp = nums[i];
47        nums[i] = nums[j];
48        nums[j] = temp;
49    }
50}