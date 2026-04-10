// Last updated: 4/9/2026, 9:20:37 PM
1class Solution {
2    public int minimumDistance(int[] nums) {
3        int n = nums.length, min = Integer.MAX_VALUE;
4        int[] freq = new int[101];
5        int[][] map = new int[101][3];
6        for (int i = 0; i < n; i++) {
7            int count = freq[nums[i]];
8            if (count < 3) {
9                map[nums[i]][count] = i;
10                freq[nums[i]]++;
11                if (freq[nums[i]] == 3) {
12                    min = Math.min(min, 2 * (i - map[nums[i]][0]));
13                }
14            } 
15            else {
16                map[nums[i]][0] = map[nums[i]][1];
17                map[nums[i]][1] = map[nums[i]][2];
18                map[nums[i]][2] = i;
19                min = Math.min(min, 2 * (i - map[nums[i]][0]));
20            }
21        }
22        return min == Integer.MAX_VALUE ? -1 : min;
23    }
24}