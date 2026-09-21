// Last updated: 9/21/2026, 12:39:13 AM
1class Solution {
2    class Node {
3        int node, state, cost;
4        String str;
5        public Node (int node, int state, int cost, String str) {
6            this.node = node;
7            this.state = state;
8            this.cost = cost;
9            this.str = str;
10        }
11    }
12    public String shortestSuperstring(String[] words) {
13        int n = words.length, min = Integer.MAX_VALUE;
14        PriorityQueue<String> candidates = new PriorityQueue<>((a, b) ->
15        a.length() - b.length());
16        List<List<int[]>> adj = new ArrayList<>();
17        for (int i = 0; i < n; i++) {
18            adj.add(new ArrayList<>());
19        }
20        for (int i = 0; i < n; i++) {
21            for (int j = 0; j < n; j++) {
22                if (i == j || words[i].equals(words[j])) {
23                    continue; // skip duplicates and edges to itself
24                }
25                adj.get(i).add(new int[]{j, helper(words[i], words[j])});
26            }
27        }
28        for (int i = 0; i < n; i++) {
29            dijkstra(adj, words, i, n, candidates);
30        }
31        return candidates.peek();
32    }
33    private void dijkstra(List<List<int[]>> adj, String[] words, 
34    int i, int n, PriorityQueue<String> candidates) {
35        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
36        boolean[][] visited = new boolean[n][1 << n];
37        pq.offer(new Node(i, 1 << i, 0, words[i])); // start with cost = 0
38        visited[i][1 << i] = true; // each node initially visits itself
39        while (!pq.isEmpty()) {
40            Node node = pq.poll();
41            int parent = node.node, state = node.state, parentDist = node.cost;
42            String str = node.str;
43            if (state == (1 << n) - 1) { // all words have been joined
44                candidates.offer(str); // add to the candidate strings
45            }
46            for (int[] neighbor : adj.get(parent)) {
47                int child = neighbor[0], childDist = neighbor[1];
48                int nextState = state | (1 << child);
49                if (!visited[child][nextState]) {
50                    visited[child][nextState] = true;
51                    StringBuilder sb = new StringBuilder(str);
52                    sb.append(words[child].substring(words[child].length() - childDist)); // append the suffix of child to parent!
53                    pq.offer(new Node(child, nextState, parentDist + childDist, sb.toString())); // dijkstra will poll minCost childs!
54                }
55            }
56        }
57    } // same method as KMP str-str lol
58    private int helper(String s, String t) {
59        int m = s.length(), n = t.length();
60        for (int i = 0; i < m; i++) {
61            if (t.startsWith(s.substring(i))) { 
62                return n - (m - i); 
63            }
64        }
65        return n;
66    }
67}