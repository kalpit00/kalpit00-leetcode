// Last updated: 2/19/2026, 6:18:49 PM
1class Solution {
2    public int subarraysDivByK(int[] nums, int k) {
3        int count = 0, n = nums.length;
4        int[] pre = new int[n + 1];
5        for (int i = 0; i < n; i++) {
6            pre[i + 1] = pre[i] + nums[i];
7        }
8        Map<Integer, Integer> map = new HashMap<>();
9        map.put(0, 1);
10        for (int i = 1; i <= n; i++) {
11            int pre_i = ((pre[i] % k) + k) % k; // avoids negative pre[i]
12            count += map.getOrDefault(pre_i, 0);
13            map.put(pre_i, map.getOrDefault(pre_i, 0) + 1);
14        }
15        return count;
16    }
17}