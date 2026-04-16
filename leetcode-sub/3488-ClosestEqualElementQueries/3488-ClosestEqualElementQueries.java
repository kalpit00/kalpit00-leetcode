// Last updated: 4/15/2026, 11:15:42 PM
1class Solution {
2    public List<Integer> solveQueries(int[] nums, int[] queries) {
3        List<Integer> res = new ArrayList<>();
4        Map<Integer, List<Integer>> map = new HashMap<>();
5        int n = nums.length, m = queries.length;
6        for (int i = 0; i < n; i++) {
7            map.putIfAbsent(nums[i], new ArrayList<>());
8            map.get(nums[i]).add(i);
9        }
10        for (int key : map.keySet()) {
11            List<Integer> indices = map.get(key);
12            indices.add(0, indices.get(indices.size() - 1) - n);
13            indices.add(indices.get(1) + n);
14        }
15        for (int i = 0; i < m; i++) {
16            int key = nums[queries[i]];
17            List<Integer> indices = map.get(key);
18            if (indices.size() == 3) {
19                res.add(-1);
20                continue;
21            }
22            int idx = Collections.binarySearch(indices, queries[i]);
23            idx = idx < 0 ? -idx - 1 : idx;
24            int min = Math.min(indices.get(idx + 1) - indices.get(idx), 
25            indices.get(idx) - indices.get(idx - 1));
26            res.add(min);
27        }
28        return res;
29    }
30}