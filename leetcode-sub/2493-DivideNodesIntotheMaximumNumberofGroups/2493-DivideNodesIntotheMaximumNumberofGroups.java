// Last updated: 3/19/2026, 1:13:41 AM
1class Solution {
2    public int magnificentSets(int n, int[][] edges) {
3        List<List<Integer>> adj = new ArrayList<>();
4        for (int i = 0; i <= n; i++) {
5            adj.add(i, new ArrayList<>());
6        }
7        for (int[] edge : edges) {
8            int u = edge[0], v = edge[1];
9            adj.get(u).add(v);
10            adj.get(v).add(u);
11        }
12        int sum = 0;
13        int[] visited = new int[n + 1];
14        for (int i = 1; i <= n; i++) {
15            if (visited[i] == 0) { // explore in components!
16                List<Integer> component = new ArrayList<>();
17                if (!dfs(i, visited, adj, 1, component)) {
18                    return -1;
19                } // now bfs starting from each node in each cc : O(N^2)!
20                int max = 0;
21                for (int node : component) {
22                    max = Math.max(max, bfs(adj, node, n));
23                } // sum the highest level from all O(N) bfs calls in each cc
24                sum += max;
25            }
26        }
27        return sum;
28    } // isGraphBipartite dfs() coloring!!!
29    private boolean dfs(int node, int[] visited, List<List<Integer>> adj,
30    int color, List<Integer> component) {
31        visited[node] = color;
32        component.add(node);
33        for (int neighbor : adj.get(node)) {
34            if (visited[neighbor] == color) { 
35                return false;
36            }
37            else if (visited[neighbor] == 0) {
38                if (!dfs(neighbor, visited, adj, -color, component)) {
39                    return false;
40                }
41            }
42        }
43        return true;
44    } // classic level order bfs!!
45    private int bfs(List<List<Integer>> adj, int src, int n) {
46        Queue<Integer> queue = new LinkedList<>();
47        boolean[] visited = new boolean[n + 1];
48        queue.offer(src);
49        visited[src] = true;
50        int level = 0;
51        while (!queue.isEmpty()) {
52            int size = queue.size();
53            for (int i = 0; i < size; i++) {
54                int node = queue.poll();
55                for (int neighbor : adj.get(node)) {
56                    if (!visited[neighbor]) {
57                        visited[neighbor] = true;
58                        queue.offer(neighbor);
59                    }
60                }
61            }
62            level++;
63        }
64        return level;
65    }
66}