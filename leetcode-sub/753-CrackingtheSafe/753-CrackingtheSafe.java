// Last updated: 3/17/2026, 3:34:34 AM
1class Solution {
2    public String crackSafe(int n, int k) {
3        StringBuilder res = new StringBuilder();
4        int mod = (int) Math.pow(k, n - 1);
5        boolean[] visited = new boolean[mod * k]; 
6        dfs(0, mod, visited, res, k);
7        for (int i = 0; i < n - 1; i++) {
8            res.append('0');
9        }
10        return res.toString();        
11    }
12
13    private void dfs(int node, int mod, boolean[] visited,
14    StringBuilder res, int k) {
15        for (int d = 0; d < k; d++) {
16            int edge = node * k + d;
17            if (!visited[edge]) {
18                visited[edge] = true;
19                int nextNode = edge % mod;
20                dfs(nextNode, mod, visited, res, k);
21                res.append(d);
22            }
23        }        
24    }
25}