// Last updated: 11/30/2025, 8:12:25 PM
1class Solution {
2    public int minSubarray(int[] nums, int p) {
3        int n = nums.length, total = 0, sum = 0, min = n;
4        for (int num : nums) {
5            total += num;
6            total %= p;
7        }
8        int target = total % p;
9        if (target == 0) {
10            return 0;
11        }
12        HashMap<Integer, Integer> map = new HashMap<>();
13        map.put(0, -1);
14        for (int i = 0; i < n; i++) {
15            sum += nums[i];
16            sum %= p;
17            int key = (sum - target + p) % p;
18            if (map.containsKey(key)) {
19                min = Math.min(min, i - map.get(key));
20            }
21            map.put(sum, i);
22        }
23        return min == n ? -1 : min;
24    }
25}