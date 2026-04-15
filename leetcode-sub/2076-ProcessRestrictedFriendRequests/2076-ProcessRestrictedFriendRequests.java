// Last updated: 4/15/2026, 4:09:44 AM
1class Solution {
2    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
3        int m = requests.length;
4        DSU dsu = new DSU(n);
5        boolean[] res = new boolean[m];
6        for (int i = 0; i < m; i++) {
7            int a = requests[i][0], b = requests[i][1];
8            int pa = dsu.findParent(a), pb = dsu.findParent(b);
9            if (pa == pb) {
10                res[i] = true;
11            }
12            boolean flag = true;
13            for (int[] restriction : restrictions) {
14                int c = restriction[0], d = restriction[1];
15                int pc = dsu.findParent(c), pd = dsu.findParent(d);
16                if ((pa == pc && pb == pd) || (pb == pc && pa == pd)) {
17                    flag = false;
18                    break;
19                }
20            }
21            if (flag) {
22                dsu.union(a, b);
23            }
24            res[i] = flag;
25        }
26        return res;
27    }
28    public class DSU {
29        int componentCount;
30        int[] size, parent;
31        public DSU(int n) {
32            size = new int[n];
33            parent = new int[n];
34            componentCount = n;
35            for (int i = 0; i < n; i++) {
36                size[i] = 1;
37                parent[i] = i;
38            }
39        }
40        public int findParent(int node) {
41            if (node == parent[node]) {
42                return node;
43            }
44            return findParent(parent[node]);
45        }
46        public boolean union(int u, int v) {
47            int pu = findParent(u), pv = findParent(v);
48            if (pu == pv) {
49                return false;
50            }
51            if (size[pu] < size[pv]) {
52                parent[pu] = pv;
53                size[pv] += size[pu];
54            }
55            else {
56                parent[pv] = pu;
57                size[pu] += size[pv];
58            }
59            componentCount--;
60            return true;
61        }
62    }
63}