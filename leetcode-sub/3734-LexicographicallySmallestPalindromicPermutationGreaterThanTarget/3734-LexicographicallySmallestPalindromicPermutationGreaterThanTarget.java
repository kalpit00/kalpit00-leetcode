// Last updated: 8/27/2026, 8:52:34 PM
1class Solution {
2
3    public String lexPalindromicPermutation(String s, String target) {
4        int n = s.length();
5        // Special case: length of 1
6        if (n == 1) {
7            return s.compareTo(target) > 0 ? s : "";
8        }
9
10        // Count the frequency of each character
11        int[] cnt = new int[26];
12        for (char c : s.toCharArray()) {
13            cnt[c - 'a']++;
14        }
15
16        // Check if it can form a palindrome and record the characters with odd occurrences
17        String oddChar = "";
18        for (int i = 0; i < 26; i++) {
19            if (cnt[i] % 2 == 1) {
20                // More than one character appears an odd number of times, cannot form a palindrome
21                if (oddChar != "") {
22                    return "";
23                }
24                oddChar = String.valueOf((char) ('a' + i));
25            }
26            cnt[i] /= 2; // It takes only half the characters to construct the left half
27        }
28
29        StringBuilder prefix = new StringBuilder();
30
31        // Construct the left part of each digit greedily
32        for (int i = 0; i < n / 2; i++) {
33            boolean found = false;
34            // Try to place the smallest character in lexicographical order
35            for (int j = 0; j < 26; j++) {
36                if (cnt[j] == 0) {
37                    continue;
38                }
39
40                cnt[j]--;
41                if (
42                    check(
43                        prefix.toString(),
44                        (char) ('a' + j),
45                        cnt,
46                        oddChar,
47                        target
48                    )
49                ) {
50                    // If the constructed palindrome is greater than target, choose the character
51                    prefix.append((char) ('a' + j));
52                    found = true;
53                    break;
54                } else {
55                    cnt[j]++; // Not meeting the conditions, reset the counter
56                }
57            }
58            if (!found) {
59                return ""; // Cannot construct a palindrome larger than target
60            }
61
62            if (prefix.charAt(i) > target.charAt(i)) {
63                // prefix is already greater than target
64                StringBuilder left = new StringBuilder(prefix);
65                for (int j = 0; j < 26; j++) {
66                    for (int k = 0; k < cnt[j]; k++) {
67                        left.append((char) ('a' + j));
68                    }
69                }
70                String palindrome =
71                    left.toString() +
72                    oddChar +
73                    new StringBuilder(left).reverse().toString();
74                return palindrome;
75            }
76        }
77
78        // Construct the final palindrome string
79        String ans =
80            prefix.toString() +
81            oddChar +
82            new StringBuilder(prefix).reverse().toString();
83        return ans;
84    }
85
86    private boolean check(
87        String prefix,
88        char c,
89        int[] cnt,
90        String oddChar,
91        String target
92    ) {
93        StringBuilder left = new StringBuilder(prefix);
94        left.append(c);
95        for (int i = 25; i >= 0; i--) {
96            for (int k = 0; k < cnt[i]; k++) {
97                left.append((char) ('a' + i));
98            }
99        }
100
101        String palindrome =
102            left.toString() +
103            oddChar +
104            new StringBuilder(left).reverse().toString();
105
106        return palindrome.compareTo(target) > 0;
107    }
108}