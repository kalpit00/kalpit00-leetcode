// Last updated: 6/23/2026, 11:02:30 PM
1class Solution {
2
3    private static final long MOD = 1_000_000_007L;
4
5    static class Matrix {
6
7        int n, m;
8        long[] data;
9
10        Matrix(int n, int m) {
11            this.n = n;
12            this.m = m;
13            this.data = new long[n * m];
14        }
15
16        long get(int i, int j) {
17            return data[i * m + j];
18        }
19
20        void set(int i, int j, long val) {
21            data[i * m + j] = val;
22        }
23
24        Matrix mul(Matrix b) {
25            Matrix res = new Matrix(n, b.m);
26            for (int i = 0; i < n; i++) {
27                for (int k = 0; k < m; k++) {
28                    long r = this.get(i, k);
29                    if (r == 0) {
30                        continue;
31                    }
32
33                    for (int j = 0; j < b.m; j++) {
34                        res.set(i, j, (res.get(i, j) + r * b.get(k, j)) % MOD);
35                    }
36                }
37            }
38            return res;
39        }
40
41        Matrix pow(long exp, Matrix res) {
42            Matrix base = new Matrix(n, m);
43            System.arraycopy(this.data, 0, base.data, 0, this.data.length);
44
45            while (exp > 0) {
46                if ((exp & 1L) == 1L) {
47                    res = res.mul(base);
48                }
49                base = base.mul(base);
50                exp >>= 1L;
51            }
52            return res;
53        }
54    }
55
56    public int zigZagArrays(int n, int l, int r) {
57        int m = r - l + 1;
58        if (n == 1) {
59            return m;
60        }
61
62        Matrix u = new Matrix(2 * m, 2 * m);
63
64        for (int i = 0; i < m; i++) {
65            for (int j = 0; j < i; j++) {
66                u.set(i, j + m, 1L);
67            }
68            for (int j = i + 1; j < m; j++) {
69                u.set(i + m, j, 1L);
70            }
71        }
72
73        Matrix dp = new Matrix(1, 2 * m);
74        for (int i = 0; i < 2 * m; i++) {
75            dp.set(0, i, 1L);
76        }
77
78        dp = u.pow(n - 1, dp);
79
80        long ans = 0;
81        for (int i = 0; i < 2 * m; i++) {
82            ans = (ans + dp.get(0, i)) % MOD;
83        }
84
85        return (int) ans;
86    }
87}