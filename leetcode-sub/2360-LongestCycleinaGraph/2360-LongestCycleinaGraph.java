// Last updated: 11/8/2025, 5:33:16 AM
class Solution {
    int flag = 0;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                adj.get(i).add(edges[i]);
            }
        }
        int res = kosaraju(n, adj);
        return flag == 0 ? -1 : res;
    }
    public int kosaraju(int n, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(adj, i, stack, visited);
            }
        }
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
            revAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j : adj.get(i)) {
                revAdj.get(j).add(i);
            }
        }
        int max = 1;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node] == 0) {
                max = Math.max(max, reverseDfs(revAdj, node, visited));
            }
        }
        return max;
    }
    private void dfs(List<List<Integer>> adj, int node, 
    Stack<Integer> stack, int[] visited) {
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 1) {
                flag = 1;
            }
            else if (visited[neighbor] == 0) {
                dfs(adj, neighbor, stack, visited);
            }
        }
        stack.push(node);
        visited[node] = 2;
    }
    private int reverseDfs(List<List<Integer>> revAdj, int node, 
    int[] visited) {
        int size = 1;
        visited[node] = 1;
        for (int neighbor : revAdj.get(node)) {
            if (visited[neighbor] == 0) {
                size += reverseDfs(revAdj, neighbor, visited);
            }
        }
        return size;
    }
}