// Last updated: 11/8/2025, 11:31:43 PM
class Solution {
    int flag = 0, timer = 1;
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
        int[] visited = new int[n];
        int[][] finish = new int[n][2];
        for (int i = 0; i < n; i++) {
            finish[i][1] = i; // need node index in finish[] as sorting!
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(adj, i, finish, visited);
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
        Arrays.sort(finish, (a, b) -> b[0] - a[0]); // revSort finish[]
        for (int i = 0; i < n; i++) {
            int node = finish[i][1];
            if (visited[node] == 0) {
                max = Math.max(max, reverseDfs(revAdj, node, visited));
            }
        }
        return max;
    }
    private void dfs(List<List<Integer>> adj, int node, int[][] finish, 
    int[] visited) {
        visited[node] = 1;
        timer++; // no need for disc time[], only finish[]
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 1) { // back edge
                flag = 1; // flag to determine an cycle exists in input
            }
            else if (visited[neighbor] == 0) {
                dfs(adj, neighbor, finish, visited);
            }
        }
        finish[node][0] = timer++;
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
        visited[node] = 2;
        return size;
    }
}