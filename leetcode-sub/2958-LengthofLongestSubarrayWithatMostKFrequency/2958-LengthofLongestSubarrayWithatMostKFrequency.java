// Last updated: 8/12/2026, 2:00:15 AM
1class Solution {
2    public int maxSubarrayLength(int[] nums, int k) {
3        int n = nums.length, max = 0, left = 0, right = 0, count = 0;
4        Map<Integer, Integer> map = new HashMap<>();
5        while (right < n) {
6            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
7            count += map.get(nums[right]) > k ? 1 : 0;
8            right++;
9            while (left < right && count > 0) {
10                count -= map.get(nums[left]) > k ? 1 : 0; 
11                map.put(nums[left], map.get(nums[left]) - 1);
12                left++;
13            }
14            max = Math.max(max, right - left);
15        }
16        return max;
17    }
18}