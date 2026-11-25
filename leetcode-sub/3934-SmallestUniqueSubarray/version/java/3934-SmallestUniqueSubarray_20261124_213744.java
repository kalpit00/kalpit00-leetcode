// Last updated: 11/24/2026, 9:37:44 PM
1class Solution {
2
3    public int smallestUniqueSubarray(int[] nums) {
4        int n = nums.length;
5
6        int[] sa = new int[n];
7        int[] rank = new int[n];
8        int[] nextRank = new int[n];
9        int[] temp = new int[n];
10
11        for (int i = 0; i < n; ++i) {
12            sa[i] = i;
13            rank[i] = nums[i];
14        }
15
16        int maxRank = 0;
17        for (int x : nums) {
18            maxRank = Math.max(maxRank, x);
19        }
20
21        int cntSize = Math.max(n + 1, maxRank + 2);
22        int[] cnt = new int[cntSize];
23
24        for (int k = 1; k < n; k <<= 1) {
25            final int kk = k;
26            // Sort by the second key first
27            Arrays.fill(cnt, 0);
28            for (int i : sa) {
29                int key = (i + kk < n ? rank[i + kk] : -1) + 1;
30                ++cnt[key];
31            }
32            for (int i = 1; i <= maxRank + 1; ++i) cnt[i] += cnt[i - 1];
33            for (int p = n - 1; p >= 0; --p) {
34                int i = sa[p];
35                int key = (i + kk < n ? rank[i + kk] : -1) + 1;
36                temp[--cnt[key]] = i;
37            }
38            int[] swap = sa;
39            sa = temp;
40            temp = swap;
41
42            // Then stably sort by the first key
43            Arrays.fill(cnt, 0);
44            for (int i : sa) {
45                int key = rank[i] + 1;
46                ++cnt[key];
47            }
48            for (int i = 1; i <= maxRank + 1; ++i) {
49                cnt[i] += cnt[i - 1];
50            }
51            for (int p = n - 1; p >= 0; --p) {
52                int i = sa[p];
53                int key = rank[i] + 1;
54                temp[--cnt[key]] = i;
55            }
56            swap = sa;
57            sa = temp;
58            temp = swap;
59
60            nextRank[sa[0]] = 0;
61            for (int i = 1; i < n; ++i) {
62                int a = sa[i - 1],
63                    b = sa[i];
64                int ax = rank[a],
65                    ay = a + kk < n ? rank[a + kk] : -1;
66                int bx = rank[b],
67                    by = b + kk < n ? rank[b + kk] : -1;
68                nextRank[b] = nextRank[a] + (ax != bx || ay != by ? 1 : 0);
69            }
70
71            int[] t = rank;
72            rank = nextRank;
73            nextRank = t;
74            maxRank = rank[sa[n - 1]];
75
76            if (maxRank == n - 1) {
77                break;
78            }
79        }
80
81        // Kasai LCP
82        int[] pos = new int[n];
83        int[] lcp = new int[n];
84        for (int i = 0; i < n; ++i) pos[sa[i]] = i;
85
86        int h = 0;
87        for (int i = 0; i < n; ++i) {
88            if (pos[i] == 0) {
89                h = 0;
90                continue;
91            }
92            int j = sa[pos[i] - 1];
93            while (i + h < n && j + h < n && nums[i + h] == nums[j + h]) {
94                ++h;
95            }
96            lcp[pos[i]] = h;
97            if (h > 0) {
98                --h;
99            }
100        }
101
102        int answer = n;
103        for (int i = 0; i < n; ++i) {
104            int next = i + 1 < n ? lcp[i + 1] : 0;
105            int need = Math.max(lcp[i], next) + 1;
106            if (sa[i] + need - 1 < n) {
107                answer = Math.min(answer, need);
108            }
109        }
110
111        return answer;
112    }
113}