// Last updated: 11/28/2025, 12:23:50 AM
1class Solution {
2    int count = 0;
3    public int maxKDivisibleComponents(int n, int[][] edges, 
4    int[] values, int k) {
5        List<List<Integer>> adj = new ArrayList<>();
6        for (int i = 0; i < n; i++) {
7            adj.add(new ArrayList<>());
8        }
9        for (int[] edge : edges) {
10            int u = edge[0], v = edge[1];
11            adj.get(u).add(v);
12            adj.get(v).add(u);
13        }
14        boolean[] visited = new boolean[n];
15        dfs(0, visited, values, k, adj);
16        return count;
17    }
18    private int dfs(int node, boolean[] visited, int[] values, int k, 
19    List<List<Integer>> adj) {
20        if (visited[node]) {
21            return 0;
22        }
23        visited[node] = true;
24        int sum = values[node];
25        for (int child : adj.get(node)) {
26            sum += dfs(child, visited, values, k, adj);
27        }
28        if (sum % k == 0) {
29            count++;
30            sum = 0;
31        }
32        return sum % k;
33    }
34}