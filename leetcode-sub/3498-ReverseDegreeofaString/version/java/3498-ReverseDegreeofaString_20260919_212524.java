// Last updated: 9/19/2026, 9:25:24 PM
1class Solution {
2    public int reverseDegree(String s) {
3        char[] arr = s.toCharArray();
4        int n = arr.length, res = 0;
5        for (int i = 0; i < n; i++) {
6            res += (26 - (arr[i] - 'a')) * (i + 1);
7        }
8        return res;
9    }
10}