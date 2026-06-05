// Last updated: 6/4/2026, 9:40:55 PM
1class Solution {
2
3    private String s;
4    private int n;
5    private long[][][] memo_cnt;
6    private long[][][] memo_sum;
7
8    public long totalWaviness(long num1, long num2) {
9        return solve(num2) - solve(num1 - 1);
10    }
11
12    // calculate the sum of fluctuation values of all numbers in the range [0, num]
13    private long solve(long num) {
14        // if the fluctuation value of numbers less than 3 is 0
15        if (num < 100) {
16            return 0L;
17        }
18        s = Long.toString(num);
19        n = s.length();
20
21        // memoized search uses two independent arrays
22        // memo_cnt[pos][x][y]: the number of valid filling schemes where the current digit is at position pos, and the previous two digits are x and y
23        memo_cnt = new long[16][10][10];
24        // memo_sum[pos][x][y]: the fluctuation value when the current position is pos, and the two left digits are x and y
25        memo_sum = new long[16][10][10];
26        for (int i = 0; i < 16; i++) {
27            for (int j = 0; j < 10; j++) {
28                Arrays.fill(memo_cnt[i][j], -1);
29                Arrays.fill(memo_sum[i][j], -1);
30            }
31        }
32
33        long[] result = dfs(0, -1, -1, true, true);
34        return result[1];
35    }
36
37    private long[] dfs(
38        int pos,
39        int prev,
40        int curr,
41        boolean isLimit,
42        boolean isLeading
43    ) {
44        // end position
45        if (pos == n) {
46            return new long[] { 1L, 0L };
47        }
48        // use memoization only when not bounded by an upper limit and without leading zeros
49        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
50            if (memo_cnt[pos][prev][curr] != -1) {
51                return new long[] {
52                    memo_cnt[pos][prev][curr],
53                    memo_sum[pos][prev][curr],
54                };
55            }
56        }
57
58        // calculate the number of schemes and fluctuation value under the current conditions
59        long cnt = 0;
60        long sum = 0;
61        int up = isLimit ? (s.charAt(pos) - '0') : 9;
62        for (int digit = 0; digit <= up; ++digit) {
63            boolean newLeading = isLeading && (digit == 0);
64            // the previous number is updated to curr
65            int newPrev = curr;
66            // the current number is updated to digit
67            int newCurr = newLeading ? -1 : digit;
68            long[] sub = dfs(
69                pos + 1,
70                newPrev,
71                newCurr,
72                isLimit && (digit == up),
73                newLeading
74            );
75            long subCnt = sub[0];
76            long subSum = sub[1];
77            // only calculate the fluctuation value when there are no leading zeros
78            if (!newLeading && prev >= 0 && curr >= 0) {
79                // when the digit is a peak or a valley, update the current fluctuation value
80                if (
81                    (prev < curr && curr > digit) ||
82                    (prev > curr && curr < digit)
83                ) {
84                    sum += subCnt;
85                }
86            }
87
88            cnt += subCnt;
89            sum += subSum;
90        }
91
92        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
93            // update the memoization array
94            memo_cnt[pos][prev][curr] = cnt;
95            memo_sum[pos][prev][curr] = sum;
96        }
97
98        return new long[] { cnt, sum };
99    }
100}