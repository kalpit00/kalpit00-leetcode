// Last updated: 11/11/2026, 8:27:53 PM
1class Solution {
2
3    public long minimumCost(
4        int cost1,
5        int cost2,
6        int costBoth,
7        int need1,
8        int need2
9    ) {
10        long totalCost = 0;
11
12        // Buying separately is cheaper; item 3 is unnecessary
13        if (cost1 + cost2 <= costBoth) {
14            totalCost = 1L * cost1 * need1 + 1L * cost2 * need2;
15        } else {
16            // Buy item 3 first until one requirement is fulfilled
17            int cnt_3 = Math.min(need1, need2);
18            totalCost = 1L * cnt_3 * costBoth;
19
20            need1 -= cnt_3;
21            need2 -= cnt_3;
22
23            // Type 1 is still needed; choose the cheaper of items 1 and 3
24            if (need1 > 0) {
25                totalCost += 1L * need1 * Math.min(cost1, costBoth);
26                // Type 2 is still needed; choose the cheaper of items 2 and 3
27            } else if (need2 > 0) {
28                totalCost += 1L * need2 * Math.min(cost2, costBoth);
29            }
30        }
31
32        return totalCost;
33    }
34}