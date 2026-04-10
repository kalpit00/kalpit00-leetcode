// Last updated: 4/9/2026, 9:26:34 PM
1class Solution {
2    public int minimumDistance(int[] nums) {
3        int n = nums.length, min = Integer.MAX_VALUE;
4        Map<Integer, int[]> map = new HashMap<>();
5        for (int i = 0; i < n; i++) {
6            map.putIfAbsent(nums[i], new int[]{-1, -1, -1});
7            int[] node = map.get(nums[i]);
8            node[0] = node[1];
9            node[1] = node[2];
10            node[2] = i;            
11            min = node[0] != -1 ? Math.min(min, i - node[0]) : min;
12        }
13        return min == Integer.MAX_VALUE ? -1 : 2 * min;
14    }
15}