// Last updated: 3/26/2025, 11:09:14 PM
class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int[] res = new int[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            int dist = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            maxHeap.offer(dist);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
            res[i] = maxHeap.size() == k ? maxHeap.peek() : -1;
        }
        return res;
    }
}