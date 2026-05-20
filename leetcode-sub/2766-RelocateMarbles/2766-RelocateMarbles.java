// Last updated: 5/20/2026, 1:32:54 AM
1class Solution {
2    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
3        Set<Integer> set = new HashSet<>();
4        int n = nums.length, m = moveFrom.length;
5        for (int i = 0; i < n; i++) {
6            set.add(nums[i]);
7        }
8        for (int i = 0; i < m; i++) {
9            set.remove(moveFrom[i]);
10            set.add(moveTo[i]);
11        }
12        List<Integer> res = new ArrayList<>(set);
13        Collections.sort(res);
14        return res;
15    }
16}