// Last updated: 4/9/2026, 9:22:06 PM
1class Solution {
2    public int minimumDistance(int[] nums) {
3        int n = nums.length, min = Integer.MAX_VALUE;
4        int[] freq = new int[101];
5        int[][] map = new int[101][3];
6        for (int i = 0; i < n; i++) {
7            if (freq[nums[i]] < 3) {
8                map[nums[i]][freq[nums[i]]] = i;
9                freq[nums[i]]++;
10            } 
11            else {
12                map[nums[i]][0] = map[nums[i]][1];
13                map[nums[i]][1] = map[nums[i]][2];
14                map[nums[i]][2] = i;
15            }
16            min = freq[nums[i]] >= 3 ? Math.min(min, 2 * (i - map[nums[i]][0])) 
17            : min;
18        }
19        return min == Integer.MAX_VALUE ? -1 : min;
20    }
21}