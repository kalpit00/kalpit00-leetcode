// Last updated: 5/13/2025, 11:52:21 AM
class Solution {
    class Node {
        int node, state, cost;
        String str;
        public Node (int node, int state, int cost, String str) {
            this.node = node;
            this.state = state;
            this.cost = cost;
            this.str = str;
        }
    }
    public String shortestSuperstring(String[] words) {
        int n = words.length, min = Integer.MAX_VALUE;
        List<String> candidates = new ArrayList<>();
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || words[i].equals(words[j])) {
                    continue; // skip duplicates and edges to itself
                }
                adj.get(i).add(new int[]{j, helper(words[i], words[j])});
            }
        }
        for (int i = 0; i < n; i++) {
            dijkstra(adj, words, i, n, candidates);
        }
        String res = "";
        for (String candidate : candidates) {
            if (min > candidate.length()) {
                min = candidate.length();
                res = candidate;
            }
        }
        return res;
    }
    private void dijkstra(List<List<int[]>> adj, String[] words, 
    int i, int n, List<String> candidates) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[][] visited = new boolean[n][1 << n];
        pq.offer(new Node(i, 1 << i, 0, words[i])); // start with cost = 0
        visited[i][1 << i] = true; // each node initially visits itself
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int parent = node.node, state = node.state, parentDist = node.cost;
            String str = node.str;
            if (state == (1 << n) - 1) { // all words have been joined
                candidates.add(str); // add to the candidate strings
            }
            for (int[] neighbor : adj.get(parent)) {
                int child = neighbor[0], childDist = neighbor[1];
                int nextState = state | (1 << child);
                if (!visited[child][nextState]) {
                    visited[child][nextState] = true;
                    StringBuilder sb = new StringBuilder(str);
                    sb.append(words[child].substring(words[child].length() - childDist)); // append the suffix of child to parent!
                    pq.offer(new Node(child, nextState, parentDist + childDist, sb.toString())); // dijkstra will poll minCost childs!
                }
            }
        }
    } // minimum chars needed to append to s to make it contain t as a suffix
    private int helper(String s, String t) {
        int m = s.length(), n = t.length();
        for (int i = 0; i < m; i++) {
            if (t.startsWith(s.substring(i))) { 
                return n - (m - i); 
            }
        }
        return n;
    }
}