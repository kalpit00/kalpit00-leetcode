// Last updated: 8/25/2026, 2:19:08 AM
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        boolean[] visited = new boolean[10000];
4        for (int num : nums) {
5            visited[num] = true;
6        }
7        int ans = k;
8        while (visited[ans]) {
9            ans += k;
10        }
11        return ans;
12    }
13}