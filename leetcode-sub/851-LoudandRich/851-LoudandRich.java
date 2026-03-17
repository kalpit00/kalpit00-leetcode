// Last updated: 3/17/2026, 3:45:54 AM
1class Solution {
2    public int[] loudAndRich(int[][] richer, int[] quiet) {
3        int n = quiet.length;
4        int[] indegree = new int[n], res = new int[n];
5        List<List<Integer>> adj = new ArrayList<>();
6        for (int i = 0; i < n; i++) {
7            adj.add(new ArrayList<>());
8            res[i] = i;
9        }
10        for (int[] edge : richer) {
11            int u = edge[0], v = edge[1];
12            adj.get(u).add(v);
13            indegree[v]++;
14        }
15        Queue<Integer> queue = new LinkedList<>();
16        for (int i = 0; i < n; i++) {
17            if (indegree[i] == 0) {
18                queue.add(i);
19            }
20        }
21        while (!queue.isEmpty()) {
22            int node = queue.poll();
23            for (int neighbor : adj.get(node)) {
24                if (quiet[res[node]] < quiet[res[neighbor]]) {
25                    res[neighbor] = res[node];
26                }
27                indegree[neighbor]--;
28                if (indegree[neighbor] == 0) {
29                    queue.add(neighbor);
30                }
31            }
32        }
33        return res;
34    }
35}