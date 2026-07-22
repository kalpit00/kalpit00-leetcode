// Last updated: 7/21/2026, 8:59:26 PM
1class SparseTable {
2
3    private List<List<Integer>> st;
4
5    public SparseTable(List<Integer> data) {
6        st = new ArrayList<>();
7        st.add(new ArrayList<>(data));
8        int i = 1,
9            N = st.get(0).size();
10        while (2 * i <= N + 1) {
11            List<Integer> pre = st.get(st.size() - 1);
12            List<Integer> cur = new ArrayList<>();
13            for (int j = 0; j < N - 2 * i + 1; j++) {
14                cur.add(Math.max(pre.get(j), pre.get(j + i)));
15            }
16            st.add(cur);
17            i <<= 1;
18        }
19    }
20
21    public int query(int begin, int end) {
22        if (begin > end) {
23            return 0;
24        }
25        int len = end - begin + 1;
26        int lg = 31 - Integer.numberOfLeadingZeros(len);
27        return Math.max(
28            st.get(lg).get(begin),
29            st.get(lg).get(end - (1 << lg) + 1)
30        );
31    }
32}
33
34class Solution {
35
36    public List<Integer> maxActiveSectionsAfterTrade(
37        String s,
38        int[][] queries
39    ) {
40        int n = s.length();
41        int cnt1 = 0;
42        for (char c : s.toCharArray()) {
43            if (c == '1') cnt1++;
44        }
45
46        List<Integer> zeroBlocks = new ArrayList<>();
47        List<Integer> blockLeft = new ArrayList<>();
48        List<Integer> blockRight = new ArrayList<>();
49
50        int i = 0;
51        while (i < n) {
52            int st = i;
53
54            while (i < n && s.charAt(i) == s.charAt(st)) {
55                i += 1;
56            }
57
58            if (s.charAt(st) == '0') {
59                zeroBlocks.add(i - st);
60                blockLeft.add(st);
61                blockRight.add(i - 1);
62            }
63        }
64
65        int m = zeroBlocks.size();
66        if (m < 2) {
67            // continuous 0 blocks less than 2 segments, return the answer directly
68            List<Integer> result = new ArrayList<>();
69            for (int q = 0; q < queries.length; q++) {
70                result.add(cnt1);
71            }
72            return result;
73        }
74
75        List<Integer> tmpSum = new ArrayList<>();
76        for (int k = 0; k < m - 1; k++) {
77            tmpSum.add(zeroBlocks.get(k) + zeroBlocks.get(k + 1));
78        }
79        SparseTable st = new SparseTable(tmpSum);
80        List<Integer> ans = new ArrayList<>();
81
82        for (int[] q : queries) {
83            int l = q[0],
84                r = q[1];
85            int idx = lowerBound(blockRight, l);
86            int jdx = upperBound(blockLeft, r) - 1;
87
88            // at most 1 continuous block of 0s within the substring
89            if (idx > m - 1 || jdx < 0 || idx >= jdx) {
90                ans.add(cnt1);
91                continue;
92            }
93
94            int firstLen =
95                blockRight.get(idx) - Math.max(blockLeft.get(idx), l) + 1; // actual length of the first consecutive block of 0s in the substring
96            int lastLen =
97                Math.min(blockRight.get(jdx), r) - blockLeft.get(jdx) + 1; // actual length of the last consecutive block of 0s in the substring
98            // exactly 2 consecutive 0 blocks within the substring
99            if (idx + 1 == jdx) {
100                int bestGain = firstLen + lastLen;
101                ans.add(cnt1 + bestGain);
102                continue;
103            }
104
105            int val1 = firstLen + zeroBlocks.get(idx + 1);
106            int val2 = zeroBlocks.get(jdx - 1) + lastLen;
107            int val3 = st.query(idx + 1, jdx - 2);
108            int bestGain = Math.max(Math.max(val1, val2), val3);
109            ans.add(cnt1 + bestGain);
110        }
111
112        return ans;
113    }
114
115    private int lowerBound(List<Integer> list, int target) {
116        int left = 0,
117            right = list.size();
118        while (left < right) {
119            int mid = left + (right - left) / 2;
120            if (list.get(mid) < target) {
121                left = mid + 1;
122            } else {
123                right = mid;
124            }
125        }
126        return left;
127    }
128
129    private int upperBound(List<Integer> list, int target) {
130        int left = 0,
131            right = list.size();
132        while (left < right) {
133            int mid = left + (right - left) / 2;
134            if (list.get(mid) <= target) {
135                left = mid + 1;
136            } else {
137                right = mid;
138            }
139        }
140        return left;
141    }
142}