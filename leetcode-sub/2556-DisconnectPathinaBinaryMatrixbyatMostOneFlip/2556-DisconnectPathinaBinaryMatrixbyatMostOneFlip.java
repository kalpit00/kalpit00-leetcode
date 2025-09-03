// Last updated: 9/3/2025, 7:36:14 PM
class Solution {
    long[] res;
    public long[] placedCoins(int[][] edges, int[] cost) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        res = new long[n];
        dfs(0, -1, adj, cost);
        return res;
    }
    
    private List<Long> dfs(int node, int parent, List<List<Integer>> adj, int[] cost) {
        List<Long> list = new ArrayList<>();
        list.add(1L * cost[node]);
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            List<Long> child = dfs(neighbor, node, adj, cost);
            list.addAll(child);
        }
        int n = list.size();
        Collections.sort(list);
        if (n < 3) {
            res[node] = 1;
        } 
        else {
            long max = Long.MIN_VALUE;
            max = Math.max(max, list.get(n-1) * list.get(n-2) * list.get(n-3));
            max = Math.max(max, list.get(0) * list.get(1) * list.get(n-1));
            max = Math.max(max, list.get(0) * list.get(1) * list.get(2));
            res[node] = Math.max(0, max);
        } // we only need 3 most positive and 2 most negative elements!
        if (n > 5) { // prune otherwise will TLE
            List<Long> copy = new ArrayList<>();
            copy.add(list.get(0));
            copy.add(list.get(1));
            copy.add(list.get(n - 3));
            copy.add(list.get(n - 2));
            copy.add(list.get(n - 1));
            return copy;
        }
        return list;
    }
}