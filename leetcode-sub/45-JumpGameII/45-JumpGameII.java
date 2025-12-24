// Last updated: 12/24/2025, 5:19:25 PM
1class Solution {
2    public int jump(int[] nums) {
3        int n = nums.length;
4        Queue<int[]> queue = new LinkedList<>();
5        boolean[] visited = new boolean[n];
6        queue.offer(new int[]{0, 0});
7        visited[0] = true;
8        while (!queue.isEmpty()) {
9            int[] node = queue.poll();
10            int i = node[0], steps = node[1];
11            if (i == n - 1) {
12                return steps;
13            }
14            for (int j = i; j <= i + nums[i] && j < n; j++) {
15                if (!visited[j]) {
16                    visited[j] = true;
17                    queue.offer(new int[]{j, steps + 1});
18                }
19            }
20        }
21        return -1;
22    }
23}