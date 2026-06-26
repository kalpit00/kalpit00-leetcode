// Last updated: 6/25/2026, 10:38:26 PM
1class Solution {
2    public long countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length, count = n;
4        int[] pre = new int[n * 2 + 1];
5        pre[n] = 1;
6        long res = 0, sum = 0;
7        for (int i = 0; i < n; ++i) {
8            if (nums[i] == target) {
9                sum += pre[count];
10                count++;
11            } 
12            else {
13                count--;
14                sum -= pre[count];
15            }
16            pre[count]++;
17            res += sum;
18        }
19        return res;
20    }
21}