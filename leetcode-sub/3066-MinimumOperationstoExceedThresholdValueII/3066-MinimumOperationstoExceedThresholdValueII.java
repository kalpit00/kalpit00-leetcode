// Last updated: 2/2/2026, 3:03:14 PM
1class Solution {
2    public String reversePrefix(String s, int k) {
3        char[] arr = s.toCharArray();
4        int start = 0, end = k - 1;
5        while (start <= end) {
6            char c = arr[start];
7            arr[start] = arr[end];
8            arr[end] = c;
9            start++;
10            end--;
11        }
12        return String.valueOf(arr);
13    }
14}