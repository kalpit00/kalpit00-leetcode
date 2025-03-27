// Last updated: 3/26/2025, 11:10:19 PM
class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int[] res = new int[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            int a = queries[i][0] < 0 ? -queries[i][0] : queries[i][0];
            int b = queries[i][1] < 0 ? -queries[i][1] : queries[i][1];
            maxHeap.offer(a + b);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
            res[i] = maxHeap.size() == k ? maxHeap.peek() : -1;
        }
        return res;
    }
}