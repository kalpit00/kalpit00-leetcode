// Last updated: 5/13/2026, 9:45:09 PM
1class Solution {
2    public boolean isGood(int[] nums) {
3        int n = 0, count = 0;
4        for (int num : nums) {
5            n = Math.max(n, num);
6        }
7        int[] map = new int[n + 1];
8        for (int num : nums) {
9            map[num]++;
10            if (map[num] > 1 && num != n) {
11                return false;
12            }
13        }
14        return map[n] == 2 && nums.length == n + 1;
15    }
16}