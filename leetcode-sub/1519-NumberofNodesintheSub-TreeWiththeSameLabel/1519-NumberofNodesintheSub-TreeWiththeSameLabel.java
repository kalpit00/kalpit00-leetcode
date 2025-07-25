// Last updated: 7/25/2025, 4:22:56 PM
class Solution {
    int[] res;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        res = new int[n];
        char[] arr = labels.toCharArray();
        dfs(0, -1, adj, arr);
        return res;
    }
    private int[] dfs(int node, int parent, List<List<Integer>> adj, 
    char[] arr) {
        int[] map = new int[26];
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            int[] childMap = dfs(neighbor, node, adj, arr);
            for (int i = 0; i < 26; i++) {
                map[i] += childMap[i];
            }
        }
        map[arr[node] - 'a']++;
        res[node] = map[arr[node] - 'a'];
        return map;
    }
}