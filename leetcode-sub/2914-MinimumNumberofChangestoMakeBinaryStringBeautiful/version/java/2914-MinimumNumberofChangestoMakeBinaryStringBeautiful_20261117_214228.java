// Last updated: 11/17/2026, 9:42:28 PM
1class Solution {
2    public int minChanges(String s) {
3        char[] arr = s.toCharArray();
4        int n = s.length(), count = 0;
5        for (int i = 1; i < n; i += 2) {
6            count += arr[i] != arr[i - 1] ? 1 : 0;
7        }
8        return count;
9    }
10}