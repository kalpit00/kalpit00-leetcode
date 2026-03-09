// Last updated: 3/9/2026, 2:45:21 AM
1class Solution {
2    public String kthLargestNumber(String[] nums, int k) {
3        radixSort(nums);
4        int n = nums.length;
5        return nums[n - k];
6    }
7    private void radixSort(String[] nums) {
8        int max = 0, n = nums.length;
9        for (int i = 0; i < n; i++) {
10            max = Math.max(max, nums[i].length());
11        }
12        for (int k = 1; k <= max; k++) {
13            digitSort(nums, n, k);
14        }
15    }
16    private void digitSort(String[] nums, int n, int k) {
17        String[] res = new String[n];
18        int[] map = new int[10];
19        for (int i = 0; i < n; i++) {
20            int idx = nums[i].length() - k;
21            int d = idx < 0 ? 0 : nums[i].charAt(idx) - '0';
22            map[d]++;
23        }
24        for (int i = 1; i < 10; i++) {
25            map[i] += map[i - 1];
26        }
27        for (int i = n - 1; i >= 0; i--) {
28            int idx = nums[i].length() - k;
29            int d = idx < 0 ? 0 : nums[i].charAt(idx) - '0';
30            res[map[d] - 1] = nums[i];
31            map[d]--;
32        }
33        for (int i = 0; i < n; i++) {
34            nums[i] = res[i];
35        }
36    }
37}