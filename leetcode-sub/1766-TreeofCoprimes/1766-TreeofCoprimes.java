// Last updated: 4/18/2026, 3:07:31 AM
1class Solution {
2    public int[] getCoprimes(int[] nums, int[][] edges) {
3        int n = nums.length;
4        int[] res = new int[n];
5        boolean[][] gcd = new boolean[51][51];
6        List<List<Integer>> adj = new ArrayList<>();
7        for (int i = 0; i < n; i++) {
8            res[i] = -1; // avoid Arrays.fill() extra loop
9            adj.add(new ArrayList<>());
10        }
11        for (int[] edge : edges) {
12            int u = edge[0], v = edge[1];
13            adj.get(u).add(v);
14            adj.get(v).add(u);
15        }
16        int[][] dp = new int[51][2];
17        for (int i = 1; i <= 50; i++) {
18            dp[i][0] = -1;
19            for (int j = i; j <= 50; j++) {
20                if (gcd(i, j) == 1) {
21                    gcd[i][j] = gcd[j][i] = true;
22                }
23            }
24        }
25        dfs(0, -1, 0, adj, dp, nums, res, gcd);
26        return res;
27    }
28    private void dfs(int node, int parent, int depth, List<List<Integer>> adj,
29    int[][] dp, int[] nums, int[] res, boolean[][] gcd) {
30        int max = -1, i = nums[node];
31        for (int j = 1; j <= 50; j++) {
32            if (gcd[i][j] && dp[j][0] != -1 && dp[j][1] > max) {
33                res[node] = dp[j][0];
34                max = dp[j][1];
35            }
36        }
37        int k = dp[i][0], d = dp[i][1];
38        dp[i][0] = node;
39        dp[i][1] = depth;
40        for (int neighbor : adj.get(node)) {
41            if (neighbor != parent) {
42                dfs(neighbor, node, depth + 1, adj, dp, nums, res, gcd);
43            }
44        }
45        dp[i][0] = k;
46        dp[i][1] = d;
47    }
48    private int gcd(int a, int b) {
49        return a == 0 ? b : gcd(b % a, a);
50    }
51}