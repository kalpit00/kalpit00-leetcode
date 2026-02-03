// Last updated: 2/2/2026, 8:19:02 PM
1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int n = nums.length, i = 1;
4        while (i < n && nums[i - 1] < nums[i]) {
5            i++;
6        }
7        int p = i - 1;
8        while (i < n && nums[i - 1] > nums[i]) {
9            i++;
10        }
11        int q = i - 1;
12        while (i < n && nums[i - 1] < nums[i]) {
13            i++;
14        }
15        int flag = i - 1;
16        return (p != 0) && (q != p) && (flag == n - 1 && flag != q);
17    }
18}