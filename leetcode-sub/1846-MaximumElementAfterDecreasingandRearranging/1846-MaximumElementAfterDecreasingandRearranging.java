// Last updated: 6/28/2026, 2:56:12 AM
1class Solution {
2    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
3        int n = arr.length, min = 1;
4        int[] map = new int[n + 1];
5        for (int num : arr) {
6            num = num > n ? n : num;
7            map[num]++;
8        }
9        for (int i = 2; i <= n; i++) {
10            min = Math.min(min + map[i], i);
11        }
12        return min;
13    }
14}