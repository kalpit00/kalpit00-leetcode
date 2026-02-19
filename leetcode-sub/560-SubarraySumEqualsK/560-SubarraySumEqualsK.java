// Last updated: 2/19/2026, 5:48:06 PM
1public class Solution {
2    public int subarraySum(int[] nums, int k) {
3        int count = 0, n = nums.length;
4        int[] pre = new int[n + 1];
5        for (int i = 0; i < n; i++) {
6            pre[i + 1] = pre[i] + nums[i];
7        }
8        Map<Integer, Integer> map = new HashMap<>();
9        map.put(0, 1);
10        for (int i = 1; i <= n; i++) {
11            if (map.containsKey(pre[i] - k)) {
12                count += map.get(pre[i] - k);
13            }
14            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
15        }
16        return count;
17    }
18}