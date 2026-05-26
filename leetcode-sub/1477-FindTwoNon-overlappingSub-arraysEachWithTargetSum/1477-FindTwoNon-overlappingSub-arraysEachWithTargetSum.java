// Last updated: 5/26/2026, 4:48:01 AM
1class Solution {
2    public boolean checkZeroOnes(String s) {
3        char[] nums = s.toCharArray();
4        return maxStreak(nums, '1') > maxStreak(nums, '0');
5    }
6    public int maxStreak(char[] nums, char c) {
7        int n = nums.length, max = 0;
8        boolean flag = false;
9        for (int i = 0; i < n; i++) {
10            int m = 1; // m = streak length
11            flag = nums[i] == c ? true : flag;
12            while (i < n - 1 && nums[i] == c && nums[i] == nums[i + 1]) {
13                i++;
14                m++;
15            }
16            max = Math.max(max, m);
17        }
18        return flag ? max : 0;
19    }
20}