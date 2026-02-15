// Last updated: 2/14/2026, 8:46:57 PM
1class Solution {
2    public long maxAlternatingSum(int[] arr) {
3        int n = arr.length;
4        long[] nums = new long[n];
5        for (int i = 0; i < n; i++) {
6            nums[i] = arr[i] * arr[i] * 1L;
7        }
8        Arrays.sort(nums);
9        long sum = 0;
10        for (int i = 0; i < n; i++) {
11            sum += i >= n / 2 ? nums[i] : -nums[i];
12        }
13        return sum;
14    }
15}