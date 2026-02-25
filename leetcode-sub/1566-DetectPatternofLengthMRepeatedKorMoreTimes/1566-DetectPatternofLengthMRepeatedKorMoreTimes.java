// Last updated: 2/25/2026, 5:05:55 PM
1class Solution {
2    public boolean containsPattern(int[] arr, int m, int k) {
3        int n = arr.length, count = 0;
4        for (int i = 0; i < n - m; i++) {
5            count = arr[i] == arr[i + m] ? count + 1 : 0;
6            if (count == m * (k - 1)) {
7                return true;
8            }
9        }
10        return false;
11    }
12}