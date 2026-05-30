// Last updated: 5/29/2026, 9:50:53 PM
1class Solution {
2
3    private int[] bt;
4
5    private void update(int x, int v) {
6        for (; x < bt.length; x += x & -x) {
7            bt[x] = Math.max(bt[x], v);
8        }
9    }
10
11    private int query(int x) {
12        int res = 0;
13        for (; x > 0; x -= x & -x) {
14            res = Math.max(res, bt[x]);
15        }
16        return res;
17    }
18
19    public List<Boolean> getResults(int[][] queries) {
20        int mx = 50000;
21
22        TreeSet<Integer> st = new TreeSet<>();
23        st.add(0);
24        st.add(mx);
25
26        for (int[] q : queries) {
27            if (q[0] == 1) {
28                st.add(q[1]);
29            }
30        }
31
32        bt = new int[mx + 1];
33
34        int pre = 0;
35        for (int x : st) {
36            if (x == 0) continue;
37            update(x, x - pre);
38            pre = x;
39        }
40
41        List<Boolean> ans = new ArrayList<>();
42        for (int i = queries.length - 1; i >= 0; i--) {
43            int[] q = queries[i];
44            if (q[0] == 2) {
45                int x = q[1];
46                int sz = q[2];
47                int preVal = Optional.ofNullable(st.floor(x)).orElse(0);
48                int maxSpace = query(preVal);
49                maxSpace = Math.max(maxSpace, x - preVal);
50                ans.add(maxSpace >= sz);
51            } else {
52                int x = q[1];
53                int preVal = Optional.ofNullable(st.lower(x)).orElse(0);
54                int nxt = Optional.ofNullable(st.higher(x)).orElse(mx);
55                update(nxt, nxt - preVal);
56                st.remove(x);
57            }
58        }
59
60        Collections.reverse(ans);
61        return ans;
62    }
63}