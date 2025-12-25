// Last updated: 12/25/2025, 5:28:56 AM
1class Solution {
2    public long maximumHappinessSum(int[] happiness, int k) {
3        long sum = 0;
4        Arrays.sort(happiness);
5        int round = 0, idx = happiness.length - 1;
6        for (int i = 0; i < k; i++) {
7            sum += Math.max(0, happiness[idx--] - round++);
8        }
9        return sum;
10    }
11}