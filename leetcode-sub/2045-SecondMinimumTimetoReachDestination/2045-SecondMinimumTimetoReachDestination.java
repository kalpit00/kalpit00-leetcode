// Last updated: 4/13/2025, 3:08:16 PM
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == Integer.MAX_VALUE) {
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        int len = dist[1] + 2, res = 0;
        queue.offer(1);
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == dist[node]) {
                    len--;
                    flag = true;
                    break;
                } else if (dist[neighbor] == dist[node] - 1) {
                    queue.add(neighbor);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if ((res / change) % 2 == 1) {
                res = ((res / change) + 1) * change;
            }
            res += time;
        }
        return res;
    }
}
