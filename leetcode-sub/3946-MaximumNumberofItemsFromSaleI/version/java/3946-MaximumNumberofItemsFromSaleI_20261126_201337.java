// Last updated: 11/26/2026, 8:13:37 PM
1class Solution {
2
3    public int maximumSaleItems(int[][] items, int budget) {
4        int[] f = new int[budget + 1];
5        int mn = Integer.MAX_VALUE;
6        for (int[] item : items) {
7            int factor = item[0],
8                price = item[1];
9            mn = Math.min(mn, price);
10            int cnt = 0;
11            for (int[] other : items) {
12                if (other[0] % factor == 0) {
13                    cnt++;
14                }
15            }
16            for (int j = budget; j >= price; j--) {
17                f[j] = Math.max(f[j], f[j - price] + cnt);
18            }
19        }
20        int ans = 0;
21        for (int j = 0; j <= budget; j++) {
22            ans = Math.max(ans, f[j] + (budget - j) / mn);
23        }
24        return ans;
25    }
26}