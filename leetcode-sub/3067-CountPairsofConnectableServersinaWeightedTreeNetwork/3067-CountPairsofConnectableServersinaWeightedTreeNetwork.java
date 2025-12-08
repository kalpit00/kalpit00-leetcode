// Last updated: 12/8/2025, 8:14:40 AM
1class Solution {
2    public int[] countPairsOfConnectableServers(int[][] edges, 
3    int signalSpeed) {
4        int n = edges.length + 1;
5        List<List<int[]>> adj = new ArrayList<>();
6        for (int i = 0; i < n; i++) {
7            adj.add(new ArrayList<>());
8        }
9        for (int[] edge : edges) {
10            int u = edge[0], v = edge[1], wt = edge[2];
11            adj.get(u).add(new int[]{v, wt});
12            adj.get(v).add(new int[]{u, wt});
13        }
14        int[] res = new int[n];
15        for (int i = 0; i < n; i++) {
16            res[i] = dfs(i, -1, 0, adj, signalSpeed);
17        }
18        return res;
19    }
20    private int dfs(int node, int parent, int dist, 
21    List<List<int[]>> adj, int signalSpeed) {
22        int sum = 0, count = dist > 0 && dist % signalSpeed == 0 ? 1 : 0;
23        for (int[] next : adj.get(node)) {
24            int child = next[0], wt = next[1];
25            if (child != parent) {
26                int res = dfs(child, node, dist + wt, adj, signalSpeed);
27                sum += count * res;
28                count += res;
29            }
30        }
31        return parent == -1 ? sum : count;
32    }
33}