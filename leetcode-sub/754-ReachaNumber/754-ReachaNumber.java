// Last updated: 2/17/2026, 3:19:20 AM
1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3        int max = 0, count = 0, n = costs.length;
4        for (int i = 0; i < n; i++) {
5            max = Math.max(max, costs[i]);
6        }
7        int[] map = new int[max + 1];
8        for (int num : costs) {
9            map[num]++;
10        }
11        for (int i = 0; i <= max; i++) {
12            if (coins >= i * map[i]) {
13                coins -= i * map[i];
14                count += map[i];
15            }
16            else {
17                count += coins / i;
18                return count;
19            }
20        }
21        return count;
22    }
23}