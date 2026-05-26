// Last updated: 5/26/2026, 6:26:14 PM
1class Solution {
2    int mod = 1000000007;
3    public int[] baseUnitConversions(int[][] conversions) {
4        int n = conversions.length + 1;
5        int[] res = new int[n];
6        List<List<long[]>> adj = new ArrayList<>();
7        for (int i = 0; i < n; i++) {
8            adj.add(new ArrayList<>());
9        }
10        for (int[] conv : conversions) {
11            int u = conv[0], v = conv[1], factor = conv[2];
12            adj.get(u).add(new long[]{v, factor});
13            // adj.get(v).add(new long[]{u, 1 / factor});
14        }
15        LinkedList<long[]> queue = new LinkedList<>();
16        boolean[] visited = new boolean[n];
17        visited[0] = true;
18        queue.offer(new long[]{0, 1});
19        while (!queue.isEmpty()) {
20            long[] item = queue.poll();
21            int node = (int) item[0];
22            long rate = item[1];
23            res[node] = (int) rate;
24            for (long[] neighbor : adj.get(node)) {
25                int child = (int) neighbor[0];
26                long factor = neighbor[1];
27                if (!visited[child]) {
28                    visited[child] = true;
29                    queue.offer(new long[]{neighbor[0], (rate * factor) % mod});
30                }
31            }
32        }
33        return res;
34    }
35}