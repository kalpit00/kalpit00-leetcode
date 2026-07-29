// Last updated: 7/28/2026, 8:04:59 PM
1class Solution {
2    public String smallestPalindrome(String s, int k) {
3        int n = s.length(), m = n / 2;
4        char[] res = new char[n];
5        int[] map = new int[26];
6        for (char c : s.toCharArray()) {
7            map[c - 'a']++;
8        }
9        for (int i = 0; i < 26; i++) {
10            if (map[i] % 2 == 1) {
11                map[i]--; // set mid character of pali when odd freq found!
12                res[n / 2] = (char) (i + 'a');
13            }
14            map[i] /= 2;
15        }
16        if (multinomial(map, k) < k) {
17            return "";
18        }
19        for (int idx = 0; idx < m; idx++) {
20            for (int i = 0; i < 26; i++) {
21                if (map[i] == 0) continue;
22                map[i]--;
23                long count = multinomial(map, k);
24                if (count >= k) {
25                    res[idx] = (char) (i + 'a');
26                    res[n - idx - 1] = (char) (i + 'a');
27                    break;
28                }
29                else {
30                    k -= count;
31                    map[i]++;
32                }
33            }
34        }
35        return String.valueOf(res);
36    }
37    private long multinomial(int[] map, long k) {
38        int n = 0;
39        for (int i : map) {
40            n += i;
41        }
42        long res = 1;
43        for (int i = 0; i < 26; i++) {
44            int r = map[i];
45            long count = nCr(n, r, k);
46            if (count == k + 1) {
47                return k + 1;
48            }
49            res *= count;
50            if (res > k) {
51                return k;
52            }
53            n -= r;
54        }
55        return res;
56    }
57    private long nCr(int n, int r, long k) {
58        long res = 1;
59        r = Math.min(r, n - r); // nCr = nC(n - r) property
60        for (int i = 1; i <= r; i++) {
61            res *= (n - i + 1);
62            res /= i;
63            if (res > k) {
64                return k + 1;
65            }
66        }
67        return res;
68    }
69}