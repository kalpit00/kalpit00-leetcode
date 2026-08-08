// Last updated: 8/8/2026, 2:14:42 AM
1class Solution {
2    public int countValidSubarrays(int[] nums, int x) {
3        int n = nums.length, count = 0;
4        for (int i = 0; i < n; i++) {
5            long sum = 0;
6            for (int j = i; j < n; j++) {
7                sum += nums[j];
8                if (sum % 10 == x && Long.toString(sum).toCharArray()[0] - '0' == x) {
9                    count++;
10                }
11            }
12        }
13        return count;
14    }
15}