// Last updated: 8/4/2026, 8:52:17 PM
1class Solution {
2
3    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
4        List<Integer>[] edges = new ArrayList[n];
5        for (int i = 0; i < n; i++) {
6            edges[i] = new ArrayList<>();
7        }
8        int[] inDegree = new int[n];
9
10        for (int[] inv : invocations) {
11            edges[inv[0]].add(inv[1]);
12            inDegree[inv[1]]++;
13        }
14
15        Queue<Integer> queue = new ArrayDeque<>();
16        queue.offer(k);
17        boolean[] suspicious = new boolean[n];
18        suspicious[k] = true;
19
20        while (!queue.isEmpty()) {
21            int u = queue.poll();
22            for (int v : edges[u]) {
23                inDegree[v]--;
24
25                if (!suspicious[v]) {
26                    queue.offer(v);
27                    suspicious[v] = true;
28                }
29            }
30        }
31
32        boolean canRemoveAll = true;
33        List<Integer> remaining = new ArrayList<>();
34
35        for (int i = 0; i < n; i++) {
36            if (suspicious[i] && inDegree[i] > 0) {
37                canRemoveAll = false;
38                break;
39            } else if (!suspicious[i]) {
40                remaining.add(i);
41            }
42        }
43
44        if (!canRemoveAll) {
45            List<Integer> allNodes = new ArrayList<>(n);
46            for (int i = 0; i < n; i++) {
47                allNodes.add(i);
48            }
49            return allNodes;
50        }
51
52        return remaining;
53    }
54}