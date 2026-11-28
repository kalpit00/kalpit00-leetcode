// Last updated: 11/27/2026, 10:43:16 PM
1class Solution {
2
3    public int maximumSaleItems(int[][] items, int budget) {
4        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));
5        int mx = 0;
6        for (int[] item : items) {
7            mx = Math.max(mx, item[0]);
8        }
9        int[] freq = new int[mx + 1];
10        for (int[] item : items) {
11            freq[item[0]]++;
12        }
13        for (int i = 1; i <= mx; i++) {
14            if (freq[i] > 0) {
15                for (int j = i * 2; j <= mx; j += i) {
16                    freq[i] += freq[j];
17                }
18            }
19        }
20
21        int mn = items[0][1];
22        int ans = 0;
23        for (int[] item : items) {
24            int factor = item[0],
25                price = item[1];
26            if (price - mn > mn) {
27                break;
28            }
29            int cnt = freq[factor] - 1;
30            int take = Math.min(cnt, budget / price);
31            ans += take * 2;
32            budget -= take * price;
33        }
34        ans += budget / mn;
35        return ans;
36    }
37}