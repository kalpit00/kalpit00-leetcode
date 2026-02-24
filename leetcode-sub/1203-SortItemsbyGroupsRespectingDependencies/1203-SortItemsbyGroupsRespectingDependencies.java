// Last updated: 2/24/2026, 6:47:44 PM
1class Solution {
2    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
3        for (int i = 0; i < n; i++) {
4            if (group[i] == -1) {
5                group[i] = m++;
6            }
7        }
8        List<List<Integer>> itemAdj = new ArrayList<>();
9        List<List<Integer>> groupAdj = new ArrayList<>();
10        int[] itemIndegree = new int[n], groupIndegree = new int[m];
11        for (int i = 0; i < n; i++) {
12            itemAdj.add(new ArrayList<>());
13        }
14        for (int i = 0; i < m; i++) {
15            groupAdj.add(new ArrayList<>());
16        }
17        for (int j = 0; j < n; j++) {
18            for (int i : beforeItems.get(j)) {
19                // (i -> j) represents an edge in the item graph.
20                itemAdj.get(i).add(j);
21                itemIndegree[j]++;                
22                if (group[i] != group[j]) {
23                    groupAdj.get(group[i]).add(group[j]);
24                    groupIndegree[group[j]]++;
25                }
26            }
27        }
28        int[] itemOrder = topo(n, itemAdj, itemIndegree);
29        if (itemOrder.length == 0) return new int[]{};
30        int[] groupOrder = topo(m, groupAdj, groupIndegree);
31        if (groupOrder.length == 0) return new int[]{};        
32        Map<Integer, List<Integer>> map = new HashMap<>();
33        for (int i : itemOrder) {
34            map.putIfAbsent(group[i], new ArrayList<>());
35            map.get(group[i]).add(i);
36        }        
37        int[] res = new int[n];
38        int idx = 0;
39        for (int k : groupOrder) {
40            if (!map.containsKey(k)) continue;
41            for (int item : map.get(k)) {
42                res[idx++] = item;
43            }
44        }
45        return idx == n ? res : new int[]{};
46    }
47    
48    private int[] topo(int n, List<List<Integer>> adj, int[] indegree) {
49        int[] res = new int[n];
50        int idx = 0;
51        Queue<Integer> queue = new LinkedList<>();
52        for (int i = 0; i < n; i++) {
53            if (indegree[i] == 0) {
54                queue.add(i);
55            }
56        }
57        while (!queue.isEmpty()) {
58            int node = queue.poll();
59            res[idx++] = node;
60            for (int neighbor : adj.get(node)) {
61                indegree[neighbor]--;
62                if (indegree[neighbor] == 0) {
63                    queue.add(neighbor);
64                }
65            }
66        }
67        return idx == n ? res : new int[]{};
68    }
69}