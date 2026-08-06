// Last updated: 8/6/2026, 1:31:38 AM
1class Solution {
2    public int componentValue(int[] nums, int[][] edges) {
3        List<List<Integer>> adj = new ArrayList<>();
4        int n = nums.length, sum = 0, max = 0;
5        for (int i = 0; i < n; i++) {
6            sum += nums[i];
7            max = Math.max(max, nums[i]);
8            adj.add(new ArrayList<>());
9        }
10        int k = sum / max;
11        if (sum % k == 0 && k == n) return n - 1;
12        for (int[] edge : edges) {
13            int u = edge[0], v = edge[1];
14            adj.get(u).add(v);
15            adj.get(v).add(u);
16        }
17        for (int i = k; i > 1; i--) {
18            if (sum % i == 0 && dfs(0, -1, nums, sum / i, adj) == 0) {
19                return i - 1;
20            }
21        }
22        return 0;
23    }
24    private int dfs(int node, int parent, int[] nums, int k, List<List<Integer>> adj) {
25        int sum = nums[node];
26        for (int child : adj.get(node)) {
27            if (child != parent) {
28                sum += dfs(child, node, nums, k, adj);
29                if (sum > k) {
30                    return sum;
31                }
32            }
33        }        
34        return sum == k ? 0 : sum;
35    }
36}