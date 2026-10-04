// Last updated: 10/3/2026, 11:59:51 PM
1class Solution {
2    public int waysToSplit(int[] nums) {
3        int n = nums.length, count = 0, mod = 1000000007, j = 0, k = 0;
4        int[] pre = new int[n];
5        pre[0] = nums[0];
6        for (int i = 1; i < n; i++) {
7            pre[i] = pre[i - 1] + nums[i];
8        }
9        for (int i = 0; i < n - 2; i++) {
10            while (j <= i || (j < n - 1 && pre[j] - pre[i] < pre[i])) {
11                j++;
12            }
13            while (k < j || (k < n-1 && pre[k] - pre[i] <= pre[n - 1] - pre[k])) {
14                k++;
15            }
16            k--;
17            count += (k - j + 1);
18            count %= mod;
19        }
20        return count;
21    }
22}