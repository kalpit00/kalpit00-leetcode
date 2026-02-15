// Last updated: 2/14/2026, 8:58:34 PM
1class Solution {
2    public long maxAlternatingSum(int[] arr) {
3        int n = arr.length;
4        long[] nums = new long[n];
5        for (int i = 0; i < n; i++) {
6            nums[i] = arr[i] * arr[i] * 1L;
7        }        
8        quickSelect(nums, 0, n - 1, n / 2);
9        long sum = 0;
10        for (int i = 0; i < n; i++) {
11            sum += i >= n / 2 ? nums[i] : -nums[i];
12        }
13        return sum;
14    }
15    
16    private void quickSelect(long[] nums, int start, int end, int k) {
17        if (start >= end) {
18            return;
19        }
20        
21        int pivotIndex = start + new Random().nextInt(end - start + 1);
22        int[] pivot = partition(nums, start, end, pivotIndex);
23        if (pivot[0] > k) {
24            quickSelect(nums, start, pivot[0] - 1, k);
25        } else if (pivot[1] < k) {
26            quickSelect(nums, pivot[1] + 1, end, k);
27        }
28    }
29    
30    private int[] partition(long[] nums, int start, int end, int pivotIndex) {
31        long pivot = nums[pivotIndex]; 
32        int i = start, idx = start, j = end;
33        while (idx <= j) {
34            if (nums[idx] < pivot) {
35                swap(nums, i++, idx++);
36            }
37            else if (nums[idx] > pivot) {
38                swap(nums, j--, idx);
39            }
40            else {
41                idx++;
42            }
43        }
44        return new int[]{i, j};
45    }
46    
47    private void swap(long[] nums, int i, int j) {
48        long temp = nums[i];
49        nums[i] = nums[j];
50        nums[j] = temp;
51    }
52}