// Last updated: 1/5/2026, 9:03:48 AM
1class Solution {
2    public int findShortestCycle(int n, int[][] edges) {
3        int min = Integer.MAX_VALUE;
4        List<List<Integer>> adj = new ArrayList<>();
5        for (int i = 0; i < n; i++) {
6            adj.add(new ArrayList<>());
7        }
8        for (int[] edge : edges) {
9            int u = edge[0], v = edge[1];
10            adj.get(u).add(v);
11            adj.get(v).add(u);
12        }
13        for (int i = 0; i < n; i++) {
14            min = Math.min(min, bfs(i, adj, n));
15        }
16        return min == Integer.MAX_VALUE ? -1 : min;
17    }
18    
19    private int bfs(int start, List<List<Integer>> adj, int n) {
20        int[] d = new int[n], parent = new int[n], visited = new int[n];
21        Arrays.fill(d, Integer.MAX_VALUE);
22        Arrays.fill(parent, -1);
23        Queue<Integer> queue = new LinkedList<>();
24        queue.offer(start);
25        d[start] = 0;
26        visited[start] = 1;
27        int min = Integer.MAX_VALUE;
28        while (!queue.isEmpty()) {
29            int node = queue.poll();
30            for (int neighbor : adj.get(node)) {
31                if (visited[neighbor] == 0) { // unvisited
32                    visited[neighbor] = 1;
33                    d[neighbor] = d[node] + 1;
34                    parent[neighbor] = node;
35                    queue.offer(neighbor);
36                } 
37                else if (visited[neighbor] == 1) {
38                    min = Math.min(min, d[node] + d[neighbor] + 1);
39                } // Gray -> Gray == cycle
40            }
41            visited[node] = 2;
42        }
43        return min;
44    }
45}
46