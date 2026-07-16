// Last updated: 7/16/2026, 6:37:23 AM
1class Solution {
2    public long gcdSum(int[] nums) {
3        int n = nums.length, max = 0;
4        long sum = 0;
5        int[] arr = new int[n];
6        for (int i = 0; i < n; i++) {
7            max = Math.max(max, nums[i]);
8            arr[i] = gcd(nums[i], max);
9        }
10        Arrays.sort(arr);
11        int i = 0, j = n - 1;
12        while (i < j) {
13            sum += gcd(arr[i++], arr[j--]);
14        }
15        return sum;
16    }
17    private int gcd(int x, int y) {
18        return y == 0 ? x : gcd(y, x % y);
19    }
20}