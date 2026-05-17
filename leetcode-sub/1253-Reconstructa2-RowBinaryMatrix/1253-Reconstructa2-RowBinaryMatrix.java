// Last updated: 5/17/2026, 3:57:03 PM
1class Solution {
2    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colSum) {
3        int n = colSum.length;
4        List<List<Integer>> res = new ArrayList<>();
5        res.add(new ArrayList<>());
6        res.add(new ArrayList<>());
7        for (int i = 0; i < n; i++) {
8            if (colSum[i] == 0) {
9                res.get(0).add(0);
10                res.get(1).add(0);
11            }
12            else if (colSum[i] == 2) {
13                upper--;
14                lower--;
15                res.get(0).add(1);
16                res.get(1).add(1);
17            }
18            else {
19                if (upper > lower) {
20                    res.get(0).add(1);
21                    res.get(1).add(0);
22                    upper--;
23                }
24                else {
25                    res.get(0).add(0);
26                    res.get(1).add(1);
27                    lower--;
28                }
29            }
30        }
31        return upper != 0 || lower != 0 ? new ArrayList<>() : res;
32    }
33}