// Last updated: 2/6/2026, 3:33:48 PM
1class Solution {
2    long maxScore = 0;
3    int count = 0;
4    int n;
5
6    public int countHighestScoreNodes(int[] parents) {
7        n = parents.length;
8
9        List<List<Integer>> adj = new ArrayList<>();
10        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
11
12        for (int i = 1; i < n; i++) {
13            adj.get(parents[i]).add(i);
14        }
15
16        dfs(0, adj);
17        return count;
18    }
19
20    private int dfs(int u, List<List<Integer>> adj) {
21        long score = 1;
22        int size = 0; // total size of children subtrees
23
24        for (int v : adj.get(u)) {
25            int sub = dfs(v, adj);
26            score *= sub;
27            size += sub;
28        }
29
30        int remaining = n - size - 1;
31        if (remaining > 0) score *= remaining;
32
33        if (score == maxScore) {
34            count++;
35        } else if (score > maxScore) {
36            maxScore = score;
37            count = 1;
38        }
39
40        return size + 1;
41    }
42}
43