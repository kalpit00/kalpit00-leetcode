// Last updated: 2/19/2026, 7:05:18 PM
1class Solution {
2    public boolean checkSubarraySum(int[] nums, int k) {
3        int n = nums.length;
4        int[] pre = new int[n + 1];
5        for (int i = 0; i < n; i++) {
6            pre[i + 1] = pre[i] + nums[i];
7        }
8        Map<Integer, Integer> map = new HashMap<>();
9        map.put(0, 0);
10        for (int i = 1; i <= n; i++) {
11            int pre_i = pre[i] % k;
12            if (map.containsKey(pre_i) && i - map.get(pre_i) > 1) {
13                return true;
14            }
15            map.putIfAbsent(pre_i, i);
16        }
17        return false;
18    }
19}