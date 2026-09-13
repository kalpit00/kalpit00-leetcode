// Last updated: 9/12/2026, 9:51:17 PM
1class Solution {
2    public int largestOverlap(int[][] img1, int[][] img2) {
3        int n = img1.length, max = 0;
4        List<int[]> ones1 = new ArrayList<>(), ones2 = new ArrayList<>();
5        for (int r = 0; r < n; r++) {
6            for (int c = 0; c < n; c++) {
7                if (img1[r][c] == 1) ones1.add(new int[]{r, c});
8                if (img2[r][c] == 1) ones2.add(new int[]{r, c});
9            }
10        }
11        int[] map = new int[9999];
12        for (int[] p1 : ones1) {
13            for (int[] p2 : ones2) {
14                int dr = p1[0] - p2[0], dc = p1[1] - p2[1];
15                int idx = dr * 100 + dc;
16                map[idx + 5000]++;
17                max = Math.max(max, map[idx + 5000]);
18            }
19        }
20        return max;
21    }
22}