// Last updated: 2/19/2026, 7:18:56 PM
1class Solution {
2    public int minOperations(int[] nums, int x) {
3        int n = nums.length, max = -1;
4        int[] pre = new int[n + 1];
5        for (int i = 0; i < n; i++) {
6            pre[i + 1] = pre[i] + nums[i];
7        }
8        Map<Integer, Integer> map = new HashMap<>();
9        map.put(0, 0);
10        int k = pre[n] - x;
11        if (k == 0) return n;
12        for (int i = 1; i <= n; i++) {
13            if (map.containsKey(pre[i] - k)) {
14                max = Math.max(max, i - map.get(pre[i] - k));
15            }
16            map.putIfAbsent(pre[i], i);
17        }
18        return max == -1 ? max : n - max;
19    }
20}