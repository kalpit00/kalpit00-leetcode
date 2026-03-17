// Last updated: 3/17/2026, 4:11:48 AM
1class Solution {
2    public boolean possibleBipartition(int n, int[][] dislikes) {
3        List<List<Integer>> adj = new ArrayList<>();
4        for (int i = 0; i <= n; i++) {
5            adj.add(i, new ArrayList<>());
6        }
7        for (int[] edge : dislikes) {
8            int u = edge[0], v = edge[1];
9            adj.get(u).add(v);
10            adj.get(v).add(u);
11        }
12        return isBipartite(adj);
13    }
14    public boolean isBipartite(List<List<Integer>> adj) {
15        int n = adj.size();
16        int[] visited = new int[n];
17        for (int i = 0; i < n; i++) {
18            if (visited[i] == 0) { // If white, start a DFS
19                if (!dfs(i, visited, adj, 1)) {
20                    return false;
21                }
22            }
23        }
24        return true;
25    }
26    private boolean dfs(int node, int[] visited, List<List<Integer>> adj,
27    int color) {
28        visited[node] = color;
29        for (int neighbor : adj.get(node)) {
30            if (visited[neighbor] == color) { 
31                return false;
32            }
33            else if (visited[neighbor] == 0) {
34                if (!dfs(neighbor, visited, adj, -color)) {
35                    return false;
36                }
37            }
38        }
39        return true;
40    }
41}