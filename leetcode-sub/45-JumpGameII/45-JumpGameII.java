// Last updated: 12/24/2025, 5:21:28 PM
1class Solution {
2    public int jump(int[] nums) {
3        int n = nums.length, steps = 0;
4        Queue<Integer> queue = new LinkedList<>();
5        boolean[] visited = new boolean[n];
6        queue.offer(0);
7        visited[0] = true;
8        while (!queue.isEmpty()) {
9            int size = queue.size();
10            for (int k = 0; k < size; k++) {
11                int i = queue.poll();
12                if (i == n - 1) {
13                    return steps;
14                }
15                for (int j = i; j <= i + nums[i] && j < n; j++) {
16                    if (!visited[j]) {
17                        visited[j] = true;
18                        queue.offer(j);
19                    }
20                }
21            }
22            steps++;
23        }
24        return -1;
25    }
26}