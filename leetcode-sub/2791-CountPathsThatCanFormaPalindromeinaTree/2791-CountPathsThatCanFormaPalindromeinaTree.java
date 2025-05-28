// Last updated: 5/27/2025, 11:08:07 PM
class Solution {
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        } // get the parent's adjList, add child 'i' with edgeWeight!
        for (int i = 1; i < n; i++) { // start at i = 1 as i = 0 is root
            int u = parent.get(i), v = i, wt = s.charAt(i) - 'a';
            adj.get(u).add(new int[]{v, wt});
        } // 2^26 ~ 10^7, so int[] map quite large. use HashMap
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[n]; 
        dfs(0, 0, dp, map, adj);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int mask = dp[i];
            long count = map.get(mask) - 1;
            for (int j = 0; j <= 26; j++) {
                int nextMask = mask ^ (1 << j);
                count += map.getOrDefault(nextMask, 0);
            }
            sum += count;
        }
        return sum / 2;
    }
    private void dfs(int node, int mask, int[] dp, 
    Map<Integer, Integer> map, List<List<int[]>> adj) {
        dp[node] = mask;
        map.put(mask, map.getOrDefault(mask, 0) + 1);
        for (int[] neighbor : adj.get(node)) {
            int next = neighbor[0], j = neighbor[1];
            int nextMask = mask ^ (1 << j);
            dfs(next, nextMask, dp, map, adj);
        }
    }
}