// Last updated: 3/25/2026, 6:04:56 PM
1class Solution {
2    public long findMaximumScore(List<Integer> nums) {
3        int n = nums.size(), top = -1;
4        long sum = 0;
5        int[] NGE = new int[n], PGE = new int[n], stack = new int[n];
6        Arrays.fill(NGE, n - 1);
7        for (int i = 0; i < n; i++) {
8            while (top != -1 && nums.get(stack[top]) <= nums.get(i)) {
9                int t = stack[top--];
10                NGE[t] = i;
11            }
12            stack[++top] = i;
13        }
14        for (int i = 0; i < n - 1; i = NGE[i]) {
15            sum += 1L * nums.get(i) * (NGE[i] - i);
16        }
17        return sum;
18    }
19}