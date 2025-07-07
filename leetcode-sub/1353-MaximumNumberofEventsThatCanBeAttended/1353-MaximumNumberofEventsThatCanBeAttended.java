// Last updated: 7/6/2025, 8:51:54 PM
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = events.length, res = 0, i = 0, max = 0;
        for (int[] event : events) {
            max = Math.max(max, event[1]);
        }
        for (int j = 1; j <= max; j++) {
            while (i < n && events[i][0] == j) {
                minHeap.offer(events[i++][1]);
            }
            while (!minHeap.isEmpty() && minHeap.peek() < j) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }
        return res;
    }
}
