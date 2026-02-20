// Last updated: 2/20/2026, 3:54:20 AM
1class Solution {
2    public long maximumSubarraySum(int[] nums, int k) {
3        int n = nums.length;
4        long max = Long.MIN_VALUE;
5        long[] pre = new long[n + 1];
6        for (int i = 0; i < n; i++) {
7            pre[i + 1] = pre[i] + nums[i];
8        }
9        Map<Integer, Integer> map = new HashMap<>();
10        for (int i = 0; i < n; i++) {
11            if (map.containsKey(nums[i] - k)) {
12                int j = map.get(nums[i] - k);
13                max = Math.max(max, pre[i + 1] - pre[j]);
14            }
15            if (map.containsKey(nums[i] + k)) {
16                int j = map.get(nums[i] + k);
17                max = Math.max(max, pre[i + 1] - pre[j]);
18            } // trick to avoid considering every single prev 'j' behind 'i'!
19            if (map.containsKey(nums[i])) { // check if num exist in map
20                int j = map.get(nums[i]);
21                if (pre[i] - pre[j] < 0) {
22                    map.put(nums[i], i);
23                } // if the sum btw 2 identical nums is < 0, ignore this subarr
24            } // update index of num with newer 'i', this 'maxes' the sum
25            else {
26                map.put(nums[i], i);
27            }
28        }
29        return max == Long.MIN_VALUE ? 0 : max;
30    }
31}