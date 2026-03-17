// Last updated: 3/17/2026, 4:05:46 AM
1class Solution {
2    public boolean possibleBipartition(int n, int[][] dislikes) {
3        int[][] graph = new int[n + 1][];
4        Map<Integer, List<Integer>> map = new HashMap<>();
5        for (int i = 0; i <= n; i++) {
6            map.put(i, new ArrayList<>());
7        }
8        for (int[] edge : dislikes) {
9            int u = edge[0], v = edge[1];
10            map.get(u).add(v);
11            map.get(v).add(u);
12        }
13        for (int i = 0; i <= n; i++) {
14            List<Integer> list = map.get(i);
15            int k = list.size();
16            graph[i] = new int[k];
17            for (int j = 0; j < k; j++) {
18                graph[i][j] = list.get(j);
19            }
20        }
21        return isBipartite(graph);
22    }
23    public boolean isBipartite(int[][] graph) {
24        int n = graph.length;
25        int[] visited = new int[n];
26        for (int i = 0; i < n; i++) {
27            if (visited[i] == 0) { // If white, start a DFS
28                if (!dfs(i, visited, graph, 1)) {
29                    return false;
30                }
31            }
32        }
33        return true;
34    }
35    private boolean dfs(int node, int[] visited, int[][] graph, int color) {
36        visited[node] = color;
37        for (int neighbor : graph[node]) {
38            if (visited[neighbor] == color) { 
39                return false;
40            }
41            else if (visited[neighbor] == 0) {
42                if (!dfs(neighbor, visited, graph, -color)) {
43                    return false;
44                }
45            }
46        }
47        return true;
48    }
49}