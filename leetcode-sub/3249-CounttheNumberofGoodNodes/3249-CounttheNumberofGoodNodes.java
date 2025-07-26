// Last updated: 7/25/2025, 9:25:51 PM
class Solution {
    int count = 0;
    public int countGoodNodes(int[][] edges) {
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
        dfs(0, -1, adj);
        return count;
    }

    private int dfs(int node, int parent, List<List<Integer>> adj) {
        List<Integer> children = new ArrayList<>();
        int sum = 1, temp = -1;
        boolean flag = true;
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            int size = dfs(neighbor, node, adj);
            sum += size;
            if (temp == -1) {
                temp = size;
            } else if (temp != size) {
                flag = false;
            }
        }
        count += flag ? 1 : 0;
        return sum;
    }
}
