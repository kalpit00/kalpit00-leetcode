// Last updated: 5/20/2026, 9:40:22 PM
1class Solution {
2    public int numberOfSubarrays(int[] nums, int k) {
3        return atmostK(nums, k) - atmostK(nums, k - 1);
4    }
5    private int atmostK(int[] nums, int k) {
6        int n = nums.length, count = 0, left = 0, right = 0, sum = 0;
7        while (right < n) {
8            count += nums[right] % 2 == 1 ? 1 : 0;
9            right++;
10            while (count > k) {
11                count -= nums[left] % 2 == 1 ? 1 : 0;
12                left++;
13            }
14            sum += (right - left);
15        }
16        return sum;
17    }
18}
19