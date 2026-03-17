// Last updated: 3/17/2026, 3:31:25 AM
1class Solution {
2    public String crackSafe(int n, int k) {
3        if (n == 1 && k == 1) return "0";
4        Set<String> visited = new HashSet<>();
5        List<Integer> res = new LinkedList<>();
6        String src = "0".repeat(n - 1);
7        dfs(src, k, visited, res);
8        Collections.reverse(res);
9        StringBuilder sb = new StringBuilder(src);
10        for (int i : res) {
11            sb.append(i);
12        }
13        return sb.toString();
14    }
15
16    private void dfs(String node, int k, Set<String> visited,
17    List<Integer> res) {
18        for (int i = 0; i < k; i++) {
19            String neighbor = node + i;
20            if (!visited.contains(neighbor)) {
21                visited.add(neighbor);
22                dfs(neighbor.substring(1), k, visited, res);
23                res.add(i);
24            }
25        }
26    }
27}