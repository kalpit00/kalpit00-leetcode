// Last updated: 9/24/2026, 1:25:30 AM
1class Solution {
2    public int smallestIndex(int[] nums) {
3        int n = nums.length;
4        for (int i = 0; i < n; i++) {
5            int sum = 0, num = nums[i];
6            while (num > 0) {
7                sum += num % 10;
8                num /= 10;
9            }
10            if (sum == i) {
11                return i;
12            }
13        }
14        return -1;
15    }
16}