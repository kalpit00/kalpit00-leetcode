// Last updated: 12/15/2025, 9:26:08 PM
1class Result {
2
3    int[] dp0;
4    int[] dp1;
5    int size;
6
7    Result(int[] dp0, int[] dp1, int size) {
8        this.dp0 = dp0;
9        this.dp1 = dp1;
10        this.size = size;
11    }
12}
13
14class Solution {
15
16    public int maxProfit(
17        int n,
18        int[] present,
19        int[] future,
20        int[][] hierarchy,
21        int budget
22    ) {
23        List<Integer>[] g = new ArrayList[n];
24        for (int i = 0; i < n; i++) {
25            g[i] = new ArrayList<>();
26        }
27        for (int[] e : hierarchy) {
28            g[e[0] - 1].add(e[1] - 1);
29        }
30
31        return dfs(0, present, future, g, budget).dp0[budget];
32    }
33
34    private Result dfs(
35        int u,
36        int[] present,
37        int[] future,
38        List<Integer>[] g,
39        int budget
40    ) {
41        int cost = present[u];
42        int dCost = present[u] / 2;
43        // dp[u][state][budget]
44        // state = 0: Do not purchase parent node, state = 1: Must purchase parent node
45        int[] dp0 = new int[budget + 1];
46        int[] dp1 = new int[budget + 1];
47
48        // subProfit[state][budget]
49        // state = 0: discount not available, state = 1: discount available
50        int[] subProfit0 = new int[budget + 1];
51        int[] subProfit1 = new int[budget + 1];
52        int uSize = cost;
53
54        for (int v : g[u]) {
55            Result childResult = dfs(v, present, future, g, budget);
56            uSize += childResult.size;
57
58            for (int i = budget; i >= 0; i--) {
59                for (int sub = 0; sub <= Math.min(childResult.size, i); sub++) {
60                    if (i - sub >= 0) {
61                        subProfit0[i] = Math.max(
62                            subProfit0[i],
63                            subProfit0[i - sub] + childResult.dp0[sub]
64                        );
65                        subProfit1[i] = Math.max(
66                            subProfit1[i],
67                            subProfit1[i - sub] + childResult.dp1[sub]
68                        );
69                    }
70                }
71            }
72        }
73
74        for (int i = 0; i <= budget; i++) {
75            dp0[i] = subProfit0[i];
76            dp1[i] = subProfit0[i];
77            if (i >= dCost) {
78                dp1[i] = Math.max(
79                    subProfit0[i],
80                    subProfit1[i - dCost] + future[u] - dCost
81                );
82            }
83            if (i >= cost) {
84                dp0[i] = Math.max(
85                    subProfit0[i],
86                    subProfit1[i - cost] + future[u] - cost
87                );
88            }
89        }
90
91        return new Result(dp0, dp1, uSize);
92    }
93}