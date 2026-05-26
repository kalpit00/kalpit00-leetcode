// Last updated: 5/25/2026, 9:47:58 PM
1class Solution {
2    public int minSumOfLengths(int[] nums, int target) {
3        int n = nums.length, sum = 0, j = 0, 
4        min = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
5        int[] pre = new int[n], suf = new int[n];
6        for (int i = 0; i < n; i++) {
7            sum += nums[i];
8            while (j <= i && sum > target) {
9                sum -= nums[j++];
10            }
11            pre[i] = (sum == target) ? (min = Math.min(min, i - j + 1)) : min;
12        }
13        min = Integer.MAX_VALUE;
14        sum = 0;
15        j = n - 1;
16        for (int i = n - 1; i >= 0; i--) { 
17            sum += nums[i];           
18            while (j > i && sum > target) {
19                sum -= nums[j--];
20            }
21            suf[i] = (sum == target) ? (min = Math.min(min, j - i + 1)) : min;
22        }
23        for (int i = 0; i < n - 1; i++) {
24            if (pre[i] == Integer.MAX_VALUE || suf[i+1] == Integer.MAX_VALUE) {
25                continue;
26            }
27            res = Math.min(res, pre[i] + suf[i + 1]);
28        }
29        return res == Integer.MAX_VALUE ? -1 : res;
30    }
31}