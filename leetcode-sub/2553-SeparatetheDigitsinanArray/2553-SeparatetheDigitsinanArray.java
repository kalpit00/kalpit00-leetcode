// Last updated: 5/10/2026, 8:05:31 PM
1class Solution {
2    public int[] separateDigits(int[] nums) {
3        int n = 0;
4        for (int num : nums) {
5            n += (int) (Math.log10(num) + 1);
6        }
7        int[] res = new int[n];
8        int idx = n - 1;
9        for (int i = nums.length - 1; i >= 0; i--) {
10            while (nums[i] > 0) {
11                res[idx--] = nums[i] % 10;
12                nums[i] /= 10;
13            }
14        }
15        return res;
16    }
17}