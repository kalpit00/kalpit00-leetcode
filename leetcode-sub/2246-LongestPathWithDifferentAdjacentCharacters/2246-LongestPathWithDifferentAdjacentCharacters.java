// Last updated: 3/27/2026, 6:08:16 AM
1class Solution {
2    int max = 0;
3    public int longestPath(int[] parent, String str) {
4        int n = parent.length;
5        char[] s = str.toCharArray();
6        List<List<Integer>> adj = new ArrayList<>();
7        for (int i = 0; i < n; i++) {
8            adj.add(new ArrayList<>());
9        }
10        for (int i = 1; i < n; i++) {
11            adj.get(parent[i]).add(i);
12        }
13        dfs(0, adj, s);
14        return max;
15    }
16    private int dfs(int i, List<List<Integer>> adj, char[] s) {
17        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
18        for (int j : adj.get(i)) {
19            int ans = dfs(j, adj, s);
20            if (s[i] != s[j]) {
21                pq.offer(ans);
22            }
23        }
24        int firstMax = pq.isEmpty() ? 0 : pq.poll();
25        int secondMax = pq.isEmpty() ? 0 : pq.poll();
26        max = Math.max(max, 1 + firstMax + secondMax);
27        return 1 + firstMax;
28    }
29}