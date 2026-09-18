// Last updated: 9/17/2026, 9:21:09 PM
1class Solution {
2    public List<String> maxNumOfSubstrings(String s) {
3        int n = s.length();
4        int[] left = new int[26], right = new int[26];
5        Arrays.fill(left, -1);
6        Arrays.fill(right, -1);
7        for (int i = 0; i < n; i++) {
8            int c = s.charAt(i) - 'a';
9            if (left[c] == -1) left[c] = i;
10            right[c] = i;
11        }
12        List<int[]> candidates = new ArrayList<>();
13        for (int c = 0; c < 26; c++) {
14            if (left[c] == -1) continue;
15            int start = left[c], end = right[c];
16            boolean valid = true;
17            for (int j = start; j <= end; j++) {
18                int ch = s.charAt(j) - 'a';
19                if (left[ch] < start) {
20                    valid = false;
21                    break;
22                }
23                end = Math.max(end, right[ch]);
24            }            
25            if (valid) {
26                for (int j = start; j <= end; j++) {
27                    int ch = s.charAt(j) - 'a';
28                    if (left[ch] < start || right[ch] > end) {
29                        valid = false;
30                        break;
31                    }
32                }
33            }
34            if (valid) {
35                candidates.add(new int[]{start, end});
36            }
37        }        
38        candidates.sort((a, b) -> a[0] - b[0]);
39        List<int[]> uniqueCandidates = new ArrayList<>();
40        for (int[] interval : candidates) {
41            if (uniqueCandidates.isEmpty() || 
42                uniqueCandidates.get(uniqueCandidates.size() - 1)[0] != 
43                interval[0] ||
44                uniqueCandidates.get(uniqueCandidates.size() - 1)[1] !=
45                interval[1]) {
46                uniqueCandidates.add(interval);
47            }
48        }
49        candidates = uniqueCandidates;
50        int m = candidates.size();
51        if (m == 0) return new ArrayList<>();        
52        List<List<Integer>> adj = new ArrayList<>();
53        for (int i = 0; i < m; i++) {
54            adj.add(new ArrayList<>());
55        }
56        for (int i = 0; i < m; i++) {
57            int[] intv1 = candidates.get(i);
58            for (int j = 0; j < m; j++) {
59                if (i == j) continue;
60                int[] intv2 = candidates.get(j);
61                // If intervals overlap and i starts before j, add edge i -> j
62                if (intv1[0] < intv2[0] && 
63                !(intv1[1] < intv2[0] || intv2[1] < intv1[0])) {
64                    adj.get(i).add(j);
65                }
66            }
67        }        
68        List<List<Integer>> sccs = kosaraju(m, adj);        
69        // Step 5: From each SCC, choose the shortest interval
70        List<int[]> chosen = new ArrayList<>();
71        for (List<Integer> comp : sccs) {
72            int[] best = null;
73            for (int idx : comp) {
74                int[] cur = candidates.get(idx);
75                if (best == null || (cur[1] - cur[0]) < (best[1] - best[0])) {
76                    best = cur;
77                }
78            }
79            chosen.add(best);
80        }        
81        chosen.sort((a, b) -> Integer.compare(a[1], b[1])); // Sort by end time
82        List<int[]> resultIntervals = new ArrayList<>();
83        int prevEnd = -1;
84        for (int[] intv : chosen) {
85            if (intv[0] > prevEnd) {
86                resultIntervals.add(intv);
87                prevEnd = intv[1];
88            }
89        }
90        resultIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));
91        List<String> result = new ArrayList<>();
92        for (int[] intv : resultIntervals) {
93            result.add(s.substring(intv[0], intv[1] + 1));
94        }
95        return result;
96    }
97    
98    public List<List<Integer>> kosaraju(int n, List<List<Integer>> adj) {
99        Stack<Integer> stack = new Stack<>();
100        boolean[] visited = new boolean[n];
101        
102        // First DFS to fill stack
103        for (int i = 0; i < n; i++) {
104            if (!visited[i]) {
105                dfs(adj, i, stack, visited);
106            }
107        }
108        
109        // Build reverse adjacency list
110        List<List<Integer>> revAdj = new ArrayList<>();
111        for (int i = 0; i < n; i++) {
112            visited[i] = false;
113            revAdj.add(new ArrayList<>());
114        }
115        for (int i = 0; i < n; i++) {
116            for (int j : adj.get(i)) {
117                revAdj.get(j).add(i);
118            }
119        }
120        
121        // Second DFS to find SCCs
122        List<List<Integer>> sccs = new ArrayList<>();
123        while (!stack.isEmpty()) {
124            int node = stack.pop();
125            if (!visited[node]) {
126                List<Integer> component = new ArrayList<>();
127                reverseDfs(revAdj, node, visited, component);
128                sccs.add(component);
129            }
130        }
131        return sccs;
132    }
133    
134    private void dfs(List<List<Integer>> adj, int node, Stack<Integer> stack, boolean[] visited) {
135        visited[node] = true;
136        for (int neighbor : adj.get(node)) {
137            if (!visited[neighbor]) {
138                dfs(adj, neighbor, stack, visited);
139            }
140        }
141        stack.push(node);
142    }
143    
144    private void reverseDfs(List<List<Integer>> revAdj, int node, boolean[] visited, List<Integer> component) {
145        visited[node] = true;
146        component.add(node);
147        for (int neighbor : revAdj.get(node)) {
148            if (!visited[neighbor]) {
149                reverseDfs(revAdj, neighbor, visited, component);
150            }
151        }
152    }
153}