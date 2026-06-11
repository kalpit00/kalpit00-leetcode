// Last updated: 6/11/2026, 5:27:08 AM
1class Solution {
2    public int assignEdgeWeights(int[][] edges) {
3        int n = edges.length + 1, mod = 1000000007, max = 0, count = 1;
4        List<List<Integer>> adj = new ArrayList<>(n + 1);
5        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
6        for (int[] edge : edges) {
7            int u = edge[0], v = edge[1];
8            adj.get(u).add(v);
9            adj.get(v).add(u);
10        }
11        Queue<int[]> queue = new LinkedList<>();
12        boolean[] visited = new boolean[n + 1];
13        queue.offer(new int[]{1, 0});
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
25        } // 2^(max - 2)
26        for (int i = 0; i < max - 1; i++) {
27            count = (count * 2) % mod;
28        }
29        return count;
30    }
31}
32