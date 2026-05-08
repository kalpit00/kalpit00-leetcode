// Last updated: 5/7/2026, 9:45:49 PM
1class Solution {
2
3    private static final int MX = 1000001;
4    private static final List<Integer>[] factors = new ArrayList[MX];
5
6    static {
7        for (int i = 0; i < MX; i++) factors[i] = new ArrayList<>();
8        for (int i = 2; i < MX; i++) {
9            if (factors[i].isEmpty()) {
10                for (int j = i; j < MX; j += i) factors[j].add(i);
11            }
12        }
13    }
14
15    public int minJumps(int[] nums) {
16        int n = nums.length;
17        Map<Integer, List<Integer>> edges = new HashMap<>();
18        for (int i = 0; i < n; i++) {
19            int a = nums[i];
20            if (factors[a].size() == 1) {
21                edges.computeIfAbsent(a, k -> new ArrayList<>()).add(i);
22            }
23        }
24        int res = 0;
25        boolean[] seen = new boolean[n];
26        seen[n - 1] = true;
27        List<Integer> q = new ArrayList<>();
28        q.add(n - 1);
29        while (true) {
30            List<Integer> q2 = new ArrayList<>();
31            for (int i : q) {
32                if (i == 0) return res;
33                if (i > 0 && !seen[i - 1]) {
34                    seen[i - 1] = true;
35                    q2.add(i - 1);
36                }
37                if (i < n - 1 && !seen[i + 1]) {
38                    seen[i + 1] = true;
39                    q2.add(i + 1);
40                }
41                for (int p : factors[nums[i]]) {
42                    if (edges.containsKey(p)) {
43                        for (int j : edges.get(p)) {
44                            if (!seen[j]) {
45                                seen[j] = true;
46                                q2.add(j);
47                            }
48                        }
49                        edges.get(p).clear();
50                    }
51                }
52            }
53            q = q2;
54            res++;
55        }
56    }
57}