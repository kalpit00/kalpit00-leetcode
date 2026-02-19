// Last updated: 2/19/2026, 3:14:01 AM
1class Solution {
2    public long[] distance(int[] nums) {
3        int n = nums.length;
4        long[] arr = new long[n];
5        Map<Integer, List<Integer>> map = new HashMap<>();
6        for (int i = 0; i < n; i++) {
7            map.putIfAbsent(nums[i], new ArrayList<>());
8            map.get(nums[i]).add(i);
9        }
10        for (List<Integer> group : map.values()) {
11            int m = group.size();
12            long[] pre = new long[m], suf = new long[m];
13            for (int i = 1; i < m; i++) {
14                pre[i] = pre[i-1] + group.get(i-1);
15            }
16            for (int i = m - 2; i >= 0; i--) {
17                suf[i] = suf[i+1] + group.get(i+1);
18            }
19            for (int i = 0; i < m; i++) {
20                long idx = group.get(i);
21                long right = suf[i] - (long) (m - i - 1) * idx;
22                long left  = (long) i * idx - pre[i];
23                arr[group.get(i)] = right + left;
24            }
25        }
26        return arr;
27    }
28}