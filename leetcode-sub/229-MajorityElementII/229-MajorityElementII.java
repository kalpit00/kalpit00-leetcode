// Last updated: 8/2/2026, 7:16:26 AM
1class Solution {
2    public List<Integer> majorityElement(int[] nums) {
3        int n = nums.length;
4        Map<Integer, Integer> map = new HashMap<>();
5        for (int num : nums) {
6            map.put(num, map.getOrDefault(num, 0) + 1);
7        }
8        List<Integer> res = new ArrayList<>();
9        for (int key : map.keySet()) {
10            if (map.get(key) > n / 3) {
11                res.add(key);
12            }
13        }
14        return res;
15    }
16}