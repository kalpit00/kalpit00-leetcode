// Last updated: 1/12/2026, 7:29:49 PM
1class Solution {
2    public int centeredSubarrays(int[] nums) {
3        int n = nums.length, count = 0;
4        for (int i = 0; i < n; i++) {
5            int sum = 0;
6            Set<Integer> set = new HashSet<>();
7            for (int j = i; j < n; j++) {
8                sum += nums[j];
9                set.add(nums[j]);
10                count += set.contains(sum) ? 1 : 0;
11            }
12        }
13        return count;
14    }
15}