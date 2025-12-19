// Last updated: 12/18/2025, 8:31:46 PM
1class Solution {
2    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
3        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
4        DSU dsu = new DSU(n);
5        dsu.unionBySize(0, firstPerson);
6        int i = 0, m = meetings.length;
7        while (i < m) {
8            int curTime = meetings[i][2];
9            Set<Integer> set = new HashSet<>();
10            while (i < m && curTime == meetings[i][2]) {
11                int[] currentMeeting = meetings[i];
12                dsu.unionBySize(currentMeeting[0], currentMeeting[1]);
13                set.add(currentMeeting[0]);
14                set.add(currentMeeting[1]);
15                i++;
16            }	
17            for (int person : set) {
18                if (!dsu.connected(0, person)) {
19                    dsu.reset(person);
20                }
21            }
22        }
23        List<Integer> ans = new ArrayList<>();
24        for (int j = 0; j < n; j++) {
25            if (dsu.connected(j, 0)) {
26                ans.add(j);
27            }
28        }
29        return ans;
30    }
31    class DSU {
32        int[] size, parent;
33
34        public DSU(int n) {
35            size = new int[n];
36            parent = new int[n];
37            for (int i = 0; i < n; i++) {
38                size[i] = 1;
39                parent[i] = i;
40            }
41        }
42
43        public int findParent(int node) {
44            if (node == parent[node]) {
45                return node;
46            }
47            return parent[node] = findParent(parent[node]);
48        }
49
50        public void unionBySize(int u, int v) {
51            int pu = findParent(u), pv = findParent(v);
52            if (pu == pv) return;
53            if (size[pu] < size[pv]) {
54                parent[pu] = pv;
55                size[pv] += size[pu];
56            } else {
57                parent[pv] = pu;
58                size[pu] += size[pv];
59            }
60        }
61        public boolean connected(int u, int v) {
62            return findParent(u) == findParent(v);
63        }
64        
65        public void reset(int p) {
66            parent[p] = p;
67            size[p] = 1;
68        }
69    }
70}