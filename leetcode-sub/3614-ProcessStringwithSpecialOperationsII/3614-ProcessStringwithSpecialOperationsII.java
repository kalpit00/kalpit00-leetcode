// Last updated: 6/17/2026, 2:46:34 AM
1class Solution {
2    public char processStr(String s, long k) {
3        long n = 0;
4        for (char c : s.toCharArray()) {
5            if (Character.isLetter(c)) {
6                n++; // for char, append, so len++
7            }
8            else if (c == '*') { // delete, so len--
9                if (n > 0) n--;
10            }
11            else if (c == '#') { // duplicate, so len *= 2
12                n *= 2;
13            }
14            else { // reverse
15                // no change in length for reverse
16            }
17        }
18        if (k >= n) return '.';
19        for (int i = s.length() - 1; i >= 0; i--) {
20            char c = s.charAt(i);
21            if (Character.isLetter(c)) { // check if its kth char (1 indexed)
22                if (n == k + 1) return c;
23                n--; // opp of append is len--
24            }
25            else if (c == '*') {
26                n++; // opp of delete is len++
27            }
28            else if (c == '#') {
29                if (k >= n / 2) {
30                    k -= n / 2;
31                } // opp of duplicate is len /= 2
32                n /= 2;
33            }
34            else {
35                k = n - k - 1;
36            }  // for reverse, the position would be at other end k steps away
37        } // (its like doing n - i - 1 from right end!)
38        return '.';
39    }
40}