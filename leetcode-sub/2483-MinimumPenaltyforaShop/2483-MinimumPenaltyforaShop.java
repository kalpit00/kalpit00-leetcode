// Last updated: 12/26/2025, 5:26:11 AM
1class Solution {
2    public int bestClosingTime(String customers) {
3        char[] arr = customers.toCharArray();
4        int n = arr.length, min = Integer.MAX_VALUE, minIndex = n;
5        int[] pre = new int[n + 1], suf = new int[n + 1];
6        for (int i = 1; i <= n; i++) {
7            pre[i] = pre[i - 1] + (arr[i - 1] == 'N' ? 1 : 0);
8        }
9        for (int i = n - 2; i >= -1; i--) {
10            suf[i + 1] = suf[i + 2] + (arr[i + 1] == 'Y' ? 1 : 0);
11        }
12        for (int i = 0; i <= n; i++) {
13            if (pre[i] + suf[i] < min) {
14                min = pre[i] + suf[i];
15                minIndex = i; // minIndex, not minVal
16            }
17        }
18        return minIndex;
19    }
20}