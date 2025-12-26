// Last updated: 12/26/2025, 5:26:47 AM
1class Solution {
2    public int bestClosingTime(String customers) {
3        char[] arr = customers.toCharArray();
4        int n = arr.length, min = Integer.MAX_VALUE, minIndex = n;
5        int[] pre = new int[n + 1], suf = new int[n + 1];
6        for (int i = 1; i <= n; i++) {
7            pre[i] = pre[i - 1] + (arr[i - 1] == 'N' ? 1 : 0);
8            suf[n - i] = suf[n - i + 1] + (arr[n - i] == 'Y' ? 1 : 0);
9        }
10        for (int i = 0; i <= n; i++) {
11            if (pre[i] + suf[i] < min) {
12                min = pre[i] + suf[i];
13                minIndex = i; // minIndex, not minVal
14            }
15        }
16        return minIndex;
17    }
18}