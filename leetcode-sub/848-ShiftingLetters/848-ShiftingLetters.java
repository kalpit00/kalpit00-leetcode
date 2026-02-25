// Last updated: 2/25/2026, 6:31:38 PM
1class Solution {
2    public String shiftingLetters(String s, int[] shifts) {
3        int n = shifts.length;
4        long[] map = new long[n];
5        map[n - 1] = shifts[n - 1] % 26;
6        for (int i = n - 2; i >= 0; i--) {
7            map[i] = (map[i + 1] + shifts[i]) % 26;
8        }
9        char[] res = new char[n];
10        char[] arr = s.toCharArray();
11        for (int i = 0; i < n; i++) {
12            res[i] = (char)(((arr[i] - 'a') + map[i]) % 26 + 'a');
13        }
14        return new String(res);
15    }
16}