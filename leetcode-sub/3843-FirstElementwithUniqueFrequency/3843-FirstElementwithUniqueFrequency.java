// Last updated: 8/6/2026, 12:45:53 AM
1class Solution {
2    public int firstUniqueFreq(int[] nums) {
3        int[] map = new int[100001], buckets = new int[100001];
4        for (int num : nums) {
5            map[num]++;
6        }
7        for (int i = 0; i < map.length; i++) {
8            if (map[i] == 0) continue;
9            buckets[map[i]]++;
10        }
11        for (int i = 0; i < nums.length; i++) {
12            if (buckets[map[nums[i]]] == 1) return nums[i];
13        }
14        return -1;
15    }
16}