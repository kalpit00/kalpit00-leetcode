// Last updated: 1/16/2026, 1:23:27 AM
1class Solution {
2    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
3        Set<Integer> hEdges = getEdges(hFences, m);
4        Set<Integer> vEdges = getEdges(vFences, n);
5        long res = 0;
6        for (int e : hEdges) {
7            if (vEdges.contains(e)) {
8                res = Math.max(res, e);
9            }
10        }
11        if (res == 0) {
12            return -1;
13        } else {
14            return (int) ((res * res) % 1000000007);
15        }
16    }
17
18    private Set<Integer> getEdges(int[] fences, int border) {
19        Set<Integer> set = new HashSet<>();
20        List<Integer> list = new ArrayList<>();
21
22        for (int fence : fences) {
23            list.add(fence);
24        }
25
26        list.add(1);
27        list.add(border);
28        Collections.sort(list);
29
30        for (int i = 0; i < list.size(); i++) {
31            for (int j = i + 1; j < list.size(); j++) {
32                set.add(list.get(j) - list.get(i));
33            }
34        }
35
36        return set;
37    }
38}