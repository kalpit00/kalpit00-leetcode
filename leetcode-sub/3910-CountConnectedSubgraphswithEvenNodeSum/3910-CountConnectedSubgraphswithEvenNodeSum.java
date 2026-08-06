// Last updated: 8/6/2026, 6:43:40 PM
1class Solution {
2    List<List<Integer>> subsets = new ArrayList<>();
3    public int evenSumSubgraphs(int[] nums, int[][] edges) {
4        int n = nums.length, count = 0;
5        dfs(0, n, new ArrayList<>());
6        for (List<Integer> subset : subsets) {
7            if (subset.isEmpty()) continue;
8            int sum = 0;
9            for (int node : subset) {
10                sum += nums[node];
11            }
12            if (sum % 2 != 0) continue;
13            Set<Integer> set = new HashSet<>(subset);
14            DSU dsu = new DSU(n, subset.size());
15            for (int[] edge : edges) {
16                int u = edge[0], v = edge[1];
17                if (set.contains(u) && set.contains(v)) {
18                    dsu.union(u, v);
19                }
20            }
21            count += dsu.componentCount == 1 ? 1 : 0;
22        }
23        return count;
24    }
25    public void dfs(int i, int n, List<Integer> list) {
26        subsets.add(new ArrayList<>(list));
27        for (int idx = i; idx < n; idx++) {
28            list.add(idx);
29            dfs(idx + 1, n, list);
30            list.remove(list.size() - 1);
31        }
32    }
33    class DSU {
34        int[] size, parent;
35        int componentCount;
36        public DSU(int n, int m) {
37            size = new int[n];
38            parent = new int[n];
39            componentCount = m;
40            for (int i = 0; i < n; i++) {
41                size[i] = 1;
42                parent[i] = i;
43            }
44        }
45
46        public int findParent(int node) {
47            if (node == parent[node]) {
48                return node;
49            }
50            return parent[node] = findParent(parent[node]);
51        }
52
53        public void union(int u, int v) {
54            int pu = findParent(u), pv = findParent(v);
55            if (pu == pv) return;
56
57            if (size[pu] < size[pv]) {
58                parent[pu] = pv;
59                size[pv] += size[pu];
60            } else {
61                parent[pv] = pu;
62                size[pu] += size[pv];
63            }
64            componentCount--;
65        }
66    }
67}