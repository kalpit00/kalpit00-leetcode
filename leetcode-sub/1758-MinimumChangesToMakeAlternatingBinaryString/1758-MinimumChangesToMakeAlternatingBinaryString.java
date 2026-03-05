// Last updated: 3/4/2026, 9:19:50 PM
1class Solution {
2    public int minOperations(String s) {
3        char[] arr = s.toCharArray();
4        int count = 0, n = arr.length;
5        for (int i = 0; i < n; i++) {
6            count += (i % 2 == 0 && arr[i] == '1') || 
7            (i % 2 != 0 && arr[i] == '0') ? 1 : 0;            
8        }
9        return Math.min(count, n - count);
10    }
11}