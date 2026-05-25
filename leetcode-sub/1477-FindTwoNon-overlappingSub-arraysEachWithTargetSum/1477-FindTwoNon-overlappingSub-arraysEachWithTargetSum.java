// Last updated: 5/25/2026, 6:00:43 AM
1class Solution {
2    public int minSumOfLengths(int[] nums, int target) {
3        Map<Integer, Integer> map = new HashMap<>();
4        int n = nums.length, min = Integer.MAX_VALUE;
5        map.put(0, -1); // put 0 with -1, so j == -1 means only 1 subarr found
6        int[] dp = new int[n], pre = new int[n];
7        pre[0] = nums[0];
8        for (int i = 1; i < n; i++) {
9            pre[i] = pre[i - 1] + nums[i];
10        }
11        for (int i = 0; i < n; i++) {
12            dp[i] = i > 0 ? dp[i - 1] : Integer.MAX_VALUE;
13            if (map.containsKey(pre[i] - target)) {
14                int j = map.get(pre[i] - target);
15                dp[i] = Math.min(dp[i], i - j); // subarr[j .. i] has sum == k
16                if (j != -1 && dp[j] != Integer.MAX_VALUE) { // 2 subarrs exist
17                    min = Math.min(min, dp[j] + i - j);
18                } // sum the two subarray lengths, dp[j] is min subarr
19            }
20            map.put(pre[i], i);
21        }
22        return min == Integer.MAX_VALUE ? -1 : min;
23    }
24}