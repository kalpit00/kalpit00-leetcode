// Last updated: 2/19/2026, 6:37:39 PM
1class Solution {
2    public int numSubarraysWithSum(int[] nums, int goal) {
3        return subarraySum(nums, goal);
4    }
5    public int subarraySum(int[] nums, int k) {
6        int count = 0, n = nums.length;
7        int[] pre = new int[n + 1];
8        for (int i = 0; i < n; i++) {
9            pre[i + 1] = pre[i] + nums[i];
10        }
11        Map<Integer, Integer> map = new HashMap<>();
12        map.put(0, 1);
13        for (int i = 1; i <= n; i++) {
14            if (map.containsKey(pre[i] - k)) {
15                count += map.get(pre[i] - k);
16            }
17            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
18        }
19        return count;
20    }
21}