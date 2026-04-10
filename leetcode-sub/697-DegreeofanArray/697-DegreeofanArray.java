// Last updated: 4/9/2026, 9:28:37 PM
1class Solution {
2    public int findShortestSubArray(int[] nums) {
3        int n = nums.length, degree = 0, min = Integer.MAX_VALUE;
4        Map<Integer, int[]> map = new HashMap<>();
5        for (int i = 0; i < n; i++) { // freq, firstIdx, lastIdx
6            map.putIfAbsent(nums[i], new int[]{1, i, i}); 
7            int[] node = map.get(nums[i]);
8            node[0]++;
9            node[2] = i;
10            degree = Math.max(degree, map.get(nums[i])[0]);
11        }
12        for (int[] node : map.values()) {
13            int freq = node[0], firstIdx = node[1], lastIdx = node[2];
14            if (freq >= degree) {
15                min = Math.min(min, lastIdx - firstIdx + 1);
16            }
17        }
18        return min;
19    }
20}
21