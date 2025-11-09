// Last updated: 11/8/2025, 7:07:12 PM
class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length, max = -1;
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                indegree[edges[i]]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int neighbor = edges[node]; // no for-neigh loop as only 1 neigh
            if (neighbor == -1) continue;
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) {
                queue.offer(neighbor);
            }
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                continue;
            } // find length of cycle starting at node 'i'
            List<Integer> cycle = new ArrayList<>();
            int count = 0; // starting at i, go to next fav neighbor in cycle
            for (int j = i; indegree[j] != 0; j = edges[j]) {
                cycle.add(j);
                indegree[j] = 0; // visit the neighbor
                count++; // increase length of this cycle by 1
            }
            max = Math.max(max, count);
        }
        return max;
    }
}