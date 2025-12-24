// Last updated: 12/24/2025, 5:18:36 PM
1class Solution {
2    public int jump(int[] nums) {
3        int n = nums.length;
4        Queue<int[]> queue = new LinkedList<>();
5        boolean[] visited = new boolean[n];
6        queue.offer(new int[]{0, 0});
7        while (!queue.isEmpty()) {
8            int[] node = queue.poll();
9            int i = node[0], steps = node[1];
10            if (i == n - 1) {
11                return steps;
12            }
13            if (visited[i]) {
14                continue;
15            }
16            visited[i] = true;
17            for (int j = i; j <= i + nums[i]; j++) {
18                queue.offer(new int[]{j, steps + 1});
19            }
20        }
21        return -1;
22    }
23}