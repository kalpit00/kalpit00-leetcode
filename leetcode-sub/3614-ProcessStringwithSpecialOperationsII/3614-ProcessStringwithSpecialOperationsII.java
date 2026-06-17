// Last updated: 6/17/2026, 2:38:51 AM
1class Solution {
2    public char processStr(String s, long k) {
3        long n = 0;
4        for (char c : s.toCharArray()) {
5            if (Character.isLetter(c)) {
6                n++;
7            }
8            else if (c == '*') {
9                if (n > 0) n--;
10            }
11            else if (c == '#') {
12                n *= 2;
13            }
14        }
15        if (n < k + 1) return '.';
16        for (int i = s.length() - 1; i >= 0; i--) {
17            char c = s.charAt(i);
18            if (Character.isLetter(c)) {
19                if (n == k + 1) return c;
20                n--;
21            }
22            else if (c == '*') {
23                n++;
24            }
25            else if (c == '#') {
26                if ((n + 1) / 2 < k + 1) {
27                    k -= n / 2;
28                }
29                n = (n + 1) / 2;
30            }
31            else {
32                k = n - k - 1;
33            }
34        }
35        return '.';
36    }
37}