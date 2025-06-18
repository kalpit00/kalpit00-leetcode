// Last updated: 6/18/2025, 4:45:40 PM
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] left = new int[26], right = new int[26];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (left[c] == -1) left[c] = i;
            right[c] = i;
        }
        List<int[]> candidates = new ArrayList<>();
        for (int c = 0; c < 26; c++) {
            if (left[c] == -1) continue;
            int start = left[c], end = right[c];
            boolean valid = true;
            for (int j = start; j <= end; j++) {
                int ch = s.charAt(j) - 'a';
                if (left[ch] < start) {
                    valid = false;
                    break;
                }
                end = Math.max(end, right[ch]);
            }            
            if (valid) {
                for (int j = start; j <= end; j++) {
                    int ch = s.charAt(j) - 'a';
                    if (left[ch] < start || right[ch] > end) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                candidates.add(new int[]{start, end});
            }
        }        
        candidates.sort((a, b) -> a[0] - b[0]);
        List<int[]> uniqueCandidates = new ArrayList<>();
        for (int[] interval : candidates) {
            if (uniqueCandidates.isEmpty() || 
                uniqueCandidates.get(uniqueCandidates.size() - 1)[0] != 
                interval[0] ||
                uniqueCandidates.get(uniqueCandidates.size() - 1)[1] !=
                interval[1]) {
                uniqueCandidates.add(interval);
            }
        }
        candidates = uniqueCandidates;
        int m = candidates.size();
        if (m == 0) return new ArrayList<>();        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int[] intv1 = candidates.get(i);
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                int[] intv2 = candidates.get(j);
                // If intervals overlap and i starts before j, add edge i -> j
                if (intv1[0] < intv2[0] && 
                !(intv1[1] < intv2[0] || intv2[1] < intv1[0])) {
                    adj.get(i).add(j);
                }
            }
        }        
        List<List<Integer>> sccs = kosaraju(m, adj);        
        // Step 5: From each SCC, choose the shortest interval
        List<int[]> chosen = new ArrayList<>();
        for (List<Integer> comp : sccs) {
            int[] best = null;
            for (int idx : comp) {
                int[] cur = candidates.get(idx);
                if (best == null || (cur[1] - cur[0]) < (best[1] - best[0])) {
                    best = cur;
                }
            }
            chosen.add(best);
        }        
        chosen.sort((a, b) -> Integer.compare(a[1], b[1])); // Sort by end time
        List<int[]> resultIntervals = new ArrayList<>();
        int prevEnd = -1;
        for (int[] intv : chosen) {
            if (intv[0] > prevEnd) {
                resultIntervals.add(intv);
                prevEnd = intv[1];
            }
        }
        resultIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        List<String> result = new ArrayList<>();
        for (int[] intv : resultIntervals) {
            result.add(s.substring(intv[0], intv[1] + 1));
        }
        return result;
    }
    
    public List<List<Integer>> kosaraju(int n, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        
        // First DFS to fill stack
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, stack, visited);
            }
        }
        
        // Build reverse adjacency list
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            revAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j : adj.get(i)) {
                revAdj.get(j).add(i);
            }
        }
        
        // Second DFS to find SCCs
        List<List<Integer>> sccs = new ArrayList<>();
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                reverseDfs(revAdj, node, visited, component);
                sccs.add(component);
            }
        }
        return sccs;
    }
    
    private void dfs(List<List<Integer>> adj, int node, Stack<Integer> stack, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, stack, visited);
            }
        }
        stack.push(node);
    }
    
    private void reverseDfs(List<List<Integer>> revAdj, int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : revAdj.get(node)) {
            if (!visited[neighbor]) {
                reverseDfs(revAdj, neighbor, visited, component);
            }
        }
    }
}