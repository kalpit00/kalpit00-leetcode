// Last updated: 8/6/2026, 8:05:12 PM
1class Solution {
2
3    public String smallestNumber(String num, long t) {
4        long temp = t;
5        for (int i = 2; i <= 9; i++) {
6            while (temp % i == 0) {
7                temp /= i;
8            }
9        }
10        if (temp > 1) {
11            return "-1";
12        }
13
14        int n = num.length();
15        long[] rem = new long[n + 1];
16        rem[0] = t;
17        int pos = n - 1;
18
19        char[] numChars = num.toCharArray();
20        for (int i = 0; i < n; i++) {
21            if (numChars[i] == '0') {
22                pos = i;
23                break;
24            }
25            rem[i + 1] = rem[i] / gcd(rem[i], numChars[i] - '0');
26        }
27
28        if (rem[n] == 1) {
29            return num;
30        }
31
32        for (int i = pos; i >= 0; i--) {
33            while (++numChars[i] <= '9') {
34                long tNow = rem[i] / gcd(rem[i], numChars[i] - '0');
35                int k = 9;
36
37                for (int j = n - 1; j > i; j--) {
38                    while (tNow % k != 0) {
39                        k--;
40                    }
41                    tNow /= k;
42                    numChars[j] = (char) ('0' + k);
43                }
44
45                if (tNow == 1) {
46                    return new String(numChars);
47                }
48            }
49        }
50
51        StringBuilder ans = new StringBuilder();
52        long originalT = t;
53        for (int i = 9; i > 1; i--) {
54            while (originalT % i == 0) {
55                ans.append((char) ('0' + i));
56                originalT /= i;
57            }
58        }
59
60        int padding = Math.max(n + 1 - ans.length(), 0);
61        for (int i = 0; i < padding; i++) {
62            ans.append('1');
63        }
64
65        return ans.reverse().toString();
66    }
67
68    private long gcd(long a, long b) {
69        while (b != 0) {
70            long temp = b;
71            b = a % b;
72            a = temp;
73        }
74        return a;
75    }
76}