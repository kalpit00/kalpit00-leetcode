// Last updated: 7/26/2026, 9:46:02 PM
1class Solution {
2    public int[][] outerTrees(int[][] trees) {
3        if (trees.length <= 3) return trees;
4        Arrays.sort(trees, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
5        List<int[]> lower = new ArrayList<>(), upper = new ArrayList<>();
6        for (int[] tree: trees) {
7            while (lower.size() >= 2 && compare(lower.get(lower.size() - 2), lower.get(lower.size() - 1), tree) > 0) {
8                lower.remove(lower.size() - 1);
9            }
10            while (upper.size() >= 2 && compare(upper.get(upper.size() - 2), upper.get(upper.size() - 1), tree) < 0) {
11                upper.remove(upper.size() - 1);
12            }
13            lower.add(tree);
14            upper.add(tree);
15        }
16        Set<int[]> set = new HashSet<>();
17        for (int[] l : lower) {
18            set.add(l);
19        }
20        for (int[] u : upper) {
21            set.add(u);
22        }
23        int[][] res = new int[set.size()][2];
24        int idx = 0;
25        for (int[] s : set) {
26            res[idx++] = s;
27        }
28        return res;
29    }
30    
31    private int compare(int[] p1, int[] p2, int[] p3) {
32        int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1], x3 = p3[0], 
33        y3 = p3[1];
34        return (y3 - y2) * (x2 - x1) - (y2 - y1) * (x3 - x2);
35    }
36}