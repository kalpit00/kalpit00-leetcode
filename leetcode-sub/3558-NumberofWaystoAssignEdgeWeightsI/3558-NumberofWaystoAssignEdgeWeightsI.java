// Last updated: 6/11/2026, 5:29:14 AM
1class Solution {
2    public int assignEdgeWeights(int[][] edges) {
3        int n = edges.length+1, mod = 1000000007, max = 0, count = 1, level = 0;
4        List<List<Integer>> adj = new ArrayList<>(n + 1);
5        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
6        for (int[] edge : edges) {
7            int u = edge[0], v = edge[1];
8            adj.get(u).add(v);
9            adj.get(v).add(u);
10        }
11        Queue<Integer> queue = new LinkedList<>();
12        boolean[] visited = new boolean[n + 1];
13        queue.offer(1);
14        visited[1] = true;
15        while (!queue.isEmpty()) {
16            int size = queue.size();
17            for (int i = 0; i < size; i++) {
18                int node = queue.poll();
19                for (int neighbor : adj.get(node)) {
20                    if (!visited[neighbor]) {
21                        visited[neighbor] = true;
22                        max = Math.max(max, level + 1);
23                        queue.offer(neighbor);
24                    }
25                }
26            }
27            level++;
28        } // 2^(max - 2)
29        for (int i = 0; i < max - 1; i++) {
30            count = (count * 2) % mod;
31        }
32        return count;
33    }
34}
35