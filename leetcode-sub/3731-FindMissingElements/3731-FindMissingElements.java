// Last updated: 8/3/2026, 8:26:06 PM
1class Solution {
2    public List<Integer> findMissingElements(int[] nums) {
3        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
4        for (int num : nums) {
5            min = Math.min(min, num);
6            max = Math.max(max, num);
7        }
8        boolean[] visited = new boolean[max + 1];
9        for (int num : nums) {
10            visited[num] = true;
11        }
12        List<Integer> res = new ArrayList<>();
13        for (int i = min; i < max; i++) {
14            if (!visited[i]) {
15                res.add(i);
16            }
17        }
18        return res;
19    }
20}