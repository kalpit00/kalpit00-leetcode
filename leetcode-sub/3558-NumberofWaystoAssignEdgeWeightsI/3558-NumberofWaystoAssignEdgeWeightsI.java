// Last updated: 6/11/2026, 5:24:07 AM
1class Solution {
2    public int assignEdgeWeights(int[][] edges) {
3        int n = edges.length + 1, mod = 1000000007, max = 0;
4        List<List<Integer>> adj = new ArrayList<>(n + 1);
5        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
6        for (int[] edge : edges) {
7            int u = edge[0], v = edge[1];
8            adj.get(u).add(v);
9            adj.get(v).add(u);
10        }
11        Queue<int[]> queue = new LinkedList<>();
12        boolean[] visited = new boolean[n + 1];
13        queue.offer(new int[]{1, 1});
14        visited[1] = true;
15        while (!queue.isEmpty()) {
16            int[] node = queue.poll();
17            int parent = node[0], depth = node[1];
18            for (int neighbor : adj.get(parent)) {
19                if (!visited[neighbor]) {
20                    visited[neighbor] = true;
21                    max = Math.max(max, depth + 1);
22                    queue.offer(new int[]{neighbor, depth + 1});
23                }
24            }
25        }
26        return modPow(2, max - 2, mod);
27    }
28    // 2^x, b^exp in logN
29    private int modPow(int base, int exp, int mod) {
30        long res = 1, b = base;
31        while (exp > 0) {
32            if ((exp & 1) == 1) res = res * b % mod;
33            b = b * b % mod;
34            exp >>= 1;
35        }
36        return (int) res;
37    }
38}
39