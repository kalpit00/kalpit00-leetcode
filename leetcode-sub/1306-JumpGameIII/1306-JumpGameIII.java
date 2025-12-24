// Last updated: 12/24/2025, 5:33:20 PM
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
13            for (int j : new int[]{i + arr[i], i - arr[i]}) {
14                if (j >= 0 && j < n && !visited[j]) { 
15                    visited[j] = true;
16                    queue.offer(j);
17                }
18            }
19        }
20        return false;
21    }
22}