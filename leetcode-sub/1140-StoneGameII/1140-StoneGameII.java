// Last updated: 8/8/2026, 8:11:30 PM
1class Solution {
2    public int stoneGameII(int[] piles) {
3        int n = piles.length;
4        int[][] mem = new int[n][n];
5        int[] suffix = new int[n];
6        for (int[] r : mem) {
7            Arrays.fill(r, -1);
8        }
9        suffix[n - 1] = piles[n - 1];
10        for (int i = n - 2; i >= 0; i--) {
11            suffix[i] = suffix[i + 1] + piles[i];
12        }
13        return solve(suffix, 0, 1, mem);
14    }
15    private int solve(int[] suffix, int i, int M, int[][] mem) {
16        if (i + 2 * M >= suffix.length) {
17            return suffix[i];
18        }
19        if (mem[i][M] != -1) {
20            return mem[i][M];
21        }
22        int opp = suffix[i];
23        for (int X = 1; X <= 2 * M; X++) {
24            opp = Math.min(opp, solve(suffix, i + X, Math.max(M, X), mem));
25        }
26        return mem[i][M] = suffix[i] - opp;
27    }
28}