// Last updated: 2/15/2026, 2:54:13 AM
1class Solution {
2    public int countElements(int[] nums) {
3        int count = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
4        for (int num : nums) {
5            min = Math.min(min, num);
6            max = Math.max(max, num);
7        }
8        for (int num : nums) {
9            if (num == min || num == max) continue;
10            count++;
11        }
12        return count;
13    }
14}