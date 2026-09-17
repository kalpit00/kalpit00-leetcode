// Last updated: 9/16/2026, 11:54:51 PM
1class Solution {
2    public int minSumOfLengths(int[] nums, int target) {
3        int n = nums.length, sum = 0, j = 0, 
4        min = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
5        int[] pre = new int[n], suf = new int[n];
6        Arrays.fill(pre, Integer.MAX_VALUE);
7        Arrays.fill(suf, Integer.MAX_VALUE);
8        for (int i = 0; i < n; i++) {
9            sum += nums[i];
10            while (sum > target) {
11                sum -= nums[j++];
12            }
13            min = sum == target ? Math.min(min, i - j + 1) : min;
14            pre[i] = min;
15        }
16        min = Integer.MAX_VALUE;
17        sum = 0;
18        j = n - 1;
19        for (int i = n - 1; i >= 0; i--) { 
20            sum += nums[i];           
21            while (sum > target) {
22                sum -= nums[j--];
23            }
24            min = sum == target ? Math.min(min, j - i + 1) : min;
25            suf[i] = min;
26        }
27        for (int i = 0; i < n - 1; i++) {
28            if (pre[i] == Integer.MAX_VALUE || suf[i+1] == Integer.MAX_VALUE) {
29                continue;
30            }
31            res = Math.min(res, pre[i] + suf[i + 1]);
32        }
33        return res == Integer.MAX_VALUE ? -1 : res;
34    }
35}