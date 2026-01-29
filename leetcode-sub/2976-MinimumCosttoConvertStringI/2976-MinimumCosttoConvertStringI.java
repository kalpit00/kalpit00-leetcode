// Last updated: 1/28/2026, 9:48:02 PM
1class Solution {
2    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
3        int n = source.length(), m = cost.length;
4        long[][] times = new long[26][26];
5        for (int i = 0; i < 26; i++) {
6            for (int j = 0; j < 26; j++) {
7                times[i][j] = i == j ? 0 : Integer.MAX_VALUE;
8            }
9        }
10        for (int i = 0; i < m; i++) {
11            int parent = original[i] - 'a', child = changed[i] - 'a', weight = cost[i];
12            times[parent][child] = Math.min(times[parent][child], (long) weight);
13        }
14        for (int k = 0; k < 26; k++) {
15            for (int i = 0; i < 26; i++) {
16                for (int j = 0; j < 26; j++) {
17                    times[i][j] = Math.min(times[i][j], 
18                    times[i][k] + times[k][j]);                    
19                }
20            }
21        }
22        long sum = 0;
23        for (int i = 0; i < n; i++) {
24            int x = source.charAt(i) - 'a', y = target.charAt(i) - 'a';
25            if (x == y) {
26                continue;
27            }
28            if (times[x][y] >= Integer.MAX_VALUE) {
29                return -1;
30            }
31            sum += times[x][y];
32        }
33        return sum;
34    }
35}
36