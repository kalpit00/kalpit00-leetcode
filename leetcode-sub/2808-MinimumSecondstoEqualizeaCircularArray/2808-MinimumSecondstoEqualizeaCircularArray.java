// Last updated: 4/17/2026, 5:37:16 PM
1class Solution {
2    public int minimumSeconds(List<Integer> nums) {
3        int n = nums.size(), min = n;
4        Map<Integer, List<Integer>> map = new HashMap<>();
5        for (int i = 0; i < n; i++) {
6            map.putIfAbsent(nums.get(i), new ArrayList<>());
7            map.get(nums.get(i)).add(i);
8        }
9        for (int key : map.keySet()) {
10            List<Integer> arr = map.get(key);
11            arr.add(arr.get(0) + n);
12            int max = 0;
13            for (int i = 1; i < arr.size(); i++) {
14                max = Math.max(max, (arr.get(i) - arr.get(i - 1)));
15            }
16            min = Math.min(min, max / 2);
17        }
18        return min;
19    }
20}