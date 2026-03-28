// Last updated: 3/27/2026, 8:43:20 PM
1class Solution {
2    public String findTheString(int[][] lcp) {
3        int n = lcp.length;
4        char[] word = new char[n];
5        char current = 'a';
6        for (int i = 0; i < n; i++) {
7            if (word[i] == 0) {
8                if (current > 'z') {
9                    return "";
10                }
11                word[i] = current;
12                for (int j = i + 1; j < n; j++) {
13                    if (lcp[i][j] > 0) {
14                        word[j] = word[i];
15                    }
16                }
17                current++;
18            }
19        }
20        for (int i = n - 1; i >= 0; i--) {
21            for (int j = n - 1; j >= 0; j--) {
22                if (word[i] != word[j]) {
23                    if (lcp[i][j] != 0) {
24                        return "";
25                    }
26                } else {
27                    if (i == n - 1 || j == n - 1) {
28                        if (lcp[i][j] != 1) {
29                            return "";
30                        }
31                    } else {
32                        if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
33                            return "";
34                        }
35                    }
36                }
37            }
38        }
39
40        return new String(word);
41    }
42}