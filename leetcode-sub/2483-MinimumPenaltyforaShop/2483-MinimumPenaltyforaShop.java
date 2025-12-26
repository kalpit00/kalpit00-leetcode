// Last updated: 12/26/2025, 5:18:25 AM
1class Solution {
2    public int bestClosingTime(String customers) {
3        char[] arr = customers.toCharArray();
4        int n = arr.length, min = Integer.MAX_VALUE, ans = n;
5        int[] pre = new int[n + 1], suf = new int[n + 1];
6        for (int i = 1; i <= n; i++) {
7            pre[i] = pre[i - 1] + (arr[i - 1] == 'N' ? 1 : 0);
8            suf[n - i] = suf[n - i + 1] + (arr[n - i] == 'Y' ? 1 : 0);
9        }
10        for (int i = n; i >= 0; i--) {
11            if (pre[i] + suf[i] <= min) {
12                min = pre[i] + suf[i];
13                ans = i;
14            }
15        }
16        return ans;
17    }
18}