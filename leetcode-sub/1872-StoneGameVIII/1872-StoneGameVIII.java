// Last updated: 8/23/2026, 9:07:57 PM
1class Solution {
2    public int stoneGameVIII(int[] stones) {
3        int sum = 0, n = stones.length;
4        for (int stone : stones) {
5            sum += stone;
6        }
7        int max = sum;
8        for (int i = n - 1; i >= 2; i--) {
9            sum -= stones[i];
10            max = Math.max(max, sum - max);
11        }
12        return max;
13    }
14}