// Last updated: 12/24/2025, 5:32:48 PM
1class Solution {
2    public boolean canReach(int[] arr, int src) {
3        int n = arr.length;
4        boolean[] visited = new boolean[n];
5        Queue<Integer> queue = new LinkedList<>();
6        queue.offer(src);
7        visited[src] = true;
8        while (!queue.isEmpty()) {
9            int i = queue.poll();
10            if (arr[i] == 0) {
11                return true;
12            }
13            int[] idx = new int[]{i + arr[i], i - arr[i]};
14            for (int j : idx) {
15                if (j >= 0 && j < n && !visited[j]) { 
16                    visited[j] = true;
17                    queue.offer(j);
18                }
19            }
20        }
21        return false;
22    }
23}