// Last updated: 10/21/2026, 3:15:17 AM
1class Solution {
2
3    public int minOperations(String s) {
4        int n = s.length();
5        char mx = 'a',
6            mn = 'z';
7        boolean sorted = true;
8        for (int i = 0; i < n; i++) {
9            mx = (char) Math.max(mx, s.charAt(i));
10            mn = (char) Math.min(mn, s.charAt(i));
11            if (i > 0 && s.charAt(i - 1) > s.charAt(i)) {
12                sorted = false;
13            }
14        }
15        if (sorted) {
16            return 0;
17        }
18        if (n == 2) {
19            return -1;
20        }
21        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
22            return 1;
23        }
24        for (int i = 1; i < n - 1; i++) {
25            if (s.charAt(i) == mn || s.charAt(i) == mx) {
26                return 2;
27            }
28        }
29        return 3;
30    }
31}