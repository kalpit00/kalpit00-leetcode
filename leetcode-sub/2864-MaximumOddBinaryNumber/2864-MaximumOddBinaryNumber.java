// Last updated: 4/24/2026, 1:22:45 AM
1class Solution {
2    public String maximumOddBinaryNumber(String s) {
3        char[] arr = s.toCharArray();
4        int count = 0, n = arr.length;
5        for (int c : arr) {
6            count += c == '1' ? 1 : 0;
7        }
8        arr[n - 1] = '1';
9        count--;
10        for (int i = 0; i < n - 1; i++) {
11            arr[i] = i < count ? '1' : '0';
12        }
13        return new String(arr);
14    }
15}