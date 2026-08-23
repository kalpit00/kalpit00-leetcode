// Last updated: 8/22/2026, 11:55:14 PM
1class Solution {
2
3    public boolean sumGame(String num) {
4        int n = num.length();
5        int[] left = get(num.substring(0, n / 2));
6        int[] right = get(num.substring(n / 2, n));
7
8        int n0 = left[0],
9            q0 = left[1];
10        int n1 = right[0],
11            q1 = right[1];
12
13        return (q0 + q1) % 2 == 1 || n0 - n1 != ((q1 - q0) * 9) / 2;
14    }
15
16    private int[] get(String s) {
17        int nn = 0,
18            qq = 0;
19        for (char ch : s.toCharArray()) {
20            if (ch == '?') {
21                qq++;
22            } else {
23                nn += ch - '0';
24            }
25        }
26        return new int[] { nn, qq };
27    }
28}