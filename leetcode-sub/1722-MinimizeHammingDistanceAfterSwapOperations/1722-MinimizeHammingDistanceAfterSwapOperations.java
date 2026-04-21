// Last updated: 4/21/2026, 6:06:22 AM
1class Solution {
2    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
3        int n = source.length;
4        List<List<Integer>> adj = new ArrayList<>();
5        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
6        
7        for (int[] edge : allowedSwaps) {
8            adj.get(edge[0]).add(edge[1]);
9            adj.get(edge[1]).add(edge[0]);
10        }
11        
12        boolean[] visited = new boolean[n];
13        int hammingDist = 0;
14        
15        for (int i = 0; i < n; i++) {
16            if (!visited[i]) {
17                // Collect source and target values for this whole component
18                Map<Integer, Integer> sourceFreq = new HashMap<>();
19                Map<Integer, Integer> targetFreq = new HashMap<>();
20                dfs(i, adj, visited, sourceFreq, targetFreq, source, target);
21                
22                // Count unmatched targets AFTER the full component is collected
23                for (int val : targetFreq.keySet()) {
24                    int matched = Math.min(targetFreq.get(val),
25                                          sourceFreq.getOrDefault(val, 0));
26                    hammingDist += targetFreq.get(val) - matched;
27                }
28            }
29        }
30        return hammingDist;
31    }
32
33    private void dfs(int i, List<List<Integer>> adj, boolean[] visited,
34                     Map<Integer, Integer> sourceFreq, Map<Integer, Integer> targetFreq,
35                     int[] source, int[] target) {
36        visited[i] = true;
37        sourceFreq.merge(source[i], 1, Integer::sum);
38        targetFreq.merge(target[i], 1, Integer::sum);
39        
40        for (int j : adj.get(i)) {
41            if (!visited[j]) {
42                dfs(j, adj, visited, sourceFreq, targetFreq, source, target);
43            }
44        }
45    }
46}