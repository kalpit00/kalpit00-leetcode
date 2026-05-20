// Last updated: 5/20/2026, 1:30:55 AM
1class Solution {
2    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
3        TreeSet<Integer> set = new TreeSet<>();
4        List<Integer> res = new ArrayList<>();
5        int n = nums.length, m = moveFrom.length;
6        for (int i = 0; i < n; i++) {
7            set.add(nums[i]);
8        }
9        for (int i = 0; i < m; i++) {
10            set.remove(moveFrom[i]);
11            set.add(moveTo[i]);
12        }
13        return new ArrayList<>(set);
14    }
15}