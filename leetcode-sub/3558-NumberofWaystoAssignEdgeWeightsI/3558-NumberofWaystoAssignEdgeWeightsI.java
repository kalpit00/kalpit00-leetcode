// Last updated: 6/1/2025, 3:07:46 PM
class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1, mod = 1000000007;
        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int maxDepth = dfs(1, 0, adj);
        return modPow(2, maxDepth - 2, mod);
    }

    private int dfs(int node, int parent, List<List<Integer>> adj) {
        int max = 0;
        for (int child : adj.get(node)) {
            if (child != parent) {
                max = Math.max(max, dfs(child, node, adj));
            }
        }
        return max + 1;
    }
    // 2^x, b^exp in logN
    private int modPow(int base, int exp, int mod) {
        long res = 1, b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * b % mod;
            b = b * b % mod;
            exp >>= 1;
        }
        return (int) res;
    }
}
