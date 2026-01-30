// Last updated: 1/29/2026, 7:27:14 PM
1import java.util.*;
2
3public class Solution {
4    private Map<String, Integer> indices;
5    private List<List<Long>> costs;
6
7    private void assignIndices(List<String> original, List<String> changed) {
8        Set<String> distinctStrings = new HashSet<>(original);
9        distinctStrings.addAll(changed);
10
11        int index = 0;
12        for (String str : distinctStrings) {
13            indices.put(str, index++);
14        }
15    }
16
17    private void buildGraph(List<String> original, List<String> changed, List<Integer> cost, Map<String, Integer> indices, List<List<Pair<Integer, Integer>>> graph) {
18        int n = original.size();
19
20        for (int i = 0; i < n; ++i) {
21            int u = indices.get(original.get(i));
22            int v = indices.get(changed.get(i));
23            int w = cost.get(i);
24            graph.get(u).add(new Pair<>(v, w));
25        }
26    }
27
28    private List<Long> dijkstra(List<List<Pair<Integer, Integer>>> graph, int source, int n) {
29        List<Long> dist = new ArrayList<>(Collections.nCopies(n, 1000000000000L));
30        dist.set(source, 0L);
31
32        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(p -> -p.first));
33        pq.add(new Pair<>(0, source));
34
35        while (!pq.isEmpty()) {
36            int u = pq.peek().second;
37            int cost = -pq.peek().first;
38            pq.poll();
39
40            if (cost > dist.get(u)) continue;
41
42            for (Pair<Integer, Integer> neighbor : graph.get(u)) {
43                int v = neighbor.first;
44                int edgeCost = neighbor.second;
45
46                if (dist.get(u) + edgeCost < dist.get(v)) {
47                    dist.set(v, dist.get(u) + edgeCost);
48                    pq.add(new Pair<>(-dist.get(v).intValue(), v));
49                }
50            }
51        }
52
53        return dist;
54    }
55
56    private List<List<Long>> minCostMatrix(List<String> original, List<String> changed, List<Integer> cost) {
57        assignIndices(original, changed);
58        int n = indices.size();
59
60        // Build graph with integer indices
61        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>(n);
62        for (int i = 0; i < n; ++i) {
63            graph.add(new ArrayList<>());
64        }
65        buildGraph(original, changed, cost, indices, graph);
66
67        // Initialize cost matrix with all distances set to infinity
68        List<List<Long>> costMatrix = new ArrayList<>(n);
69        for (int i = 0; i < n; ++i) {
70            costMatrix.add(new ArrayList<>(Collections.nCopies(n, 1000000000000L)));
71        }
72
73        // Run Dijkstra's algorithm for each node
74        for (int i = 0; i < n; ++i) {
75            List<Long> distances = dijkstra(graph, i, n);
76
77            // Update the cost matrix
78            for (int j = 0; j < n; ++j) {
79                costMatrix.get(i).set(j, distances.get(j));
80            }
81        }
82
83        return costMatrix;
84    }
85
86    private long minCost(String source, String target) {
87        int n = source.length();
88
89        // Collect unique lengths present in the indices map
90        Set<Integer> uniqueLengths = new HashSet<>(indices.size());
91        for (Map.Entry<String, Integer> entry : indices.entrySet()) {
92            uniqueLengths.add(entry.getKey().length());
93        }
94
95        // Initialize dp array
96       
97       List<Long> dp = new ArrayList<>(Collections.nCopies(n + 1, 1e12).stream().map(Double::longValue).collect(Collectors.toList()));
98
99
100        // Base case: converting an empty string to an empty string costs 0
101        dp.set(0, 0L);
102
103        for (int i = 1; i <= n; ++i) {
104            for (int len : uniqueLengths) {
105                if (i - len >= 0) {
106                    String substrSource = source.substring(i - len, i);
107                    String substrTarget = target.substring(i - len, i);
108
109                    if (substrSource.equals(substrTarget)) {
110                        dp.set(i, Math.min(dp.get(i), dp.get(i - len)));
111                    } else if (indices.containsKey(substrSource) && indices.containsKey(substrTarget)) {
112                        int u = indices.get(substrSource);
113                        int v = indices.get(substrTarget);
114                        dp.set(i, Math.min(dp.get(i), dp.get(i - len) + costs.get(u).get(v)));
115                    }
116                }
117            }
118            if (source.charAt(i - 1) == target.charAt(i - 1))
119                dp.set(i, Math.min(dp.get(i), dp.get(i - 1)));
120        }
121
122        return (dp.get(n) >= 1e12) ? -1 : dp.get(n);
123    }
124
125    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
126        indices = new HashMap<>();
127        costs = minCostMatrix(Arrays.asList(original), Arrays.asList(changed), Arrays.stream(cost).boxed().collect(Collectors.toList()));
128        return minCost(source, target);
129    }
130
131    // Pair class for simplicity
132    static class Pair<A, B> {
133        A first;
134        B second;
135
136        public Pair(A first, B second) {
137            this.first = first;
138            this.second = second;
139        }
140    }
141}