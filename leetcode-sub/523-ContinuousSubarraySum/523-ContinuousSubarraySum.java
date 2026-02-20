// Last updated: 2/19/2026, 7:00:04 PM
1class Solution {
2    public boolean checkSubarraySum(int[] nums, int k) {
3        int n = nums.length;
4        int[] sum = new int[n + 1];
5        for (int i = 1; i <= n; i++) {
6            sum[i] = sum[i - 1] + nums[i - 1];
7        }
8        Set<Integer> set = new HashSet<>();
9        for (int i = 2; i <= n; i++) {
10            set.add(sum[i - 2] % k);
11            if (set.contains(sum[i] % k)) { 
12                return true;
13            }
14        }
15        return false;
16    }
17}