// Last updated: 10/14/2026, 10:18:27 PM
1class Solution {
2    public int sumCounts(List<Integer> nums) {
3        int n = nums.size(), ans = 0;
4        for (int i = 0; i < n; i++) {
5            HashSet<Integer> set = new HashSet<>();
6            for (int j = i; j < n; j++) {
7                set.add(nums.get(j));
8                ans += set.size() * set.size();
9            }
10        }
11        return ans;
12    }
13}